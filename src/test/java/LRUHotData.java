import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yaojiafeng
 * @create 2017-09-07 上午11:12
 */
public class LRUHotData implements Runnable {

    /**
     * 单位ms
     * 超时时间
     */
    static final int EXPIRATION_INTERVAL = 500;

    /**
     * 访问3次，热点数据
     */
    static final int ACCESS_COUNT_THRESHOLD = 3;

    /**
     * 缓存容量上限是1000
     */
    static final int CAPACITY = 1000;

    /**
     * 缓存数据map
     */
    ConcurrentHashMap<String, CacheData> cacheDataMap = new ConcurrentHashMap<>();

    /**
     * 过期时间map
     */
    ConcurrentSkipListMap<Long, String> expireTimeMap = new ConcurrentSkipListMap<>();

    /**
     * key双向链表,保持访问顺序
     */
    ConcurrentLinkedDeque<String> keys = new ConcurrentLinkedDeque<>();


    /**
     * @param key
     * @return
     */
    public Object getData(String key) {
        if (cacheDataMap.containsKey(key) && !cacheDataMap.get(key).isTimeout()) {
            CacheData cacheData = cacheDataMap.get(key);
            if (cacheData.isHotData()) {
                cacheData.addAccessTimeStamp(System.currentTimeMillis());
                cacheData.setExpireTime(System.currentTimeMillis() + EXPIRATION_INTERVAL);
                System.out.println("走缓存");
                return cacheData.getValue();
            }
            Object data = queryData(key);
            cacheData.setValue(data);

            cacheData.addAccessTimeStamp(System.currentTimeMillis());
            cacheData.setExpireTime(System.currentTimeMillis() + EXPIRATION_INTERVAL);
            //处理LRU
            afterPutOrAccess(cacheData);
            return data;
        } else {//第一次和超时
            CacheData cacheData = new CacheData(new AtomicInteger(1), key, null,
                    System.currentTimeMillis() + EXPIRATION_INTERVAL,
                    null);
            Object data = queryData(key);
            //设置数据
            cacheData.setValue(data);
            LinkedList<Long> accessTimeStampList = new LinkedList<>();
            accessTimeStampList.add(System.currentTimeMillis());
            //设置访问历史时间
            cacheData.setAccessTimeStampList(accessTimeStampList);
            cacheDataMap.put(key, cacheData);
            //处理LRU
            afterPutOrAccess(cacheData);
            //添加到过期map
            expireTimeMap.put(System.currentTimeMillis() + EXPIRATION_INTERVAL, key);

            return data;
        }
    }

    private void afterPutOrAccess(CacheData cacheData) {
        keys.remove(cacheData.key);
        keys.addLast(cacheData.key);
        //删除第一个key
        if (keys.size() > CAPACITY) {
            keys.removeFirst();
            cacheDataMap.remove(cacheData.key);
        }
    }

    private Object queryData(String key) {
        System.out.println("走DB");
        return key + "[" + System.currentTimeMillis() + "]";
    }

    volatile long nextExpirationTime = System.currentTimeMillis();

    volatile long currentTime;

    @Override
    public synchronized void run() {
        try {
            while (true) {
                currentTime = System.currentTimeMillis();
                if (nextExpirationTime > currentTime) {
                    this.wait(nextExpirationTime - currentTime);
                    continue;
                }
                SortedMap<Long, String> timeoutMap = expireTimeMap.headMap(nextExpirationTime, true);
                if (timeoutMap.size() != 0) {
                    for (Map.Entry<Long, String> pair : timeoutMap.entrySet()) {
                        keys.remove(pair.getValue());
                        expireTimeMap.remove(pair.getKey());
                        cacheDataMap.remove(pair.getValue());
                    }
                }
                //下一次执行时间
                nextExpirationTime += EXPIRATION_INTERVAL;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 缓存数据结果
     */
    static class CacheData {
        AtomicInteger accessCount;
        String key;
        volatile Object value;
        long expireTime;
        /**
         * 保存访问历史时间，最多3个
         */
        LinkedList<Long> accessTimeStampList;

        public CacheData(AtomicInteger accessCount, String key, Object value, long expireTime, LinkedList<Long> accessTimeStampList) {
            this.accessCount = accessCount;
            this.key = key;
            this.value = value;
            this.expireTime = expireTime;
            this.accessTimeStampList = accessTimeStampList;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(long expireTime) {
            this.expireTime = expireTime;
        }

        public LinkedList<Long> getAccessTimeStampList() {
            return accessTimeStampList;
        }

        public void setAccessTimeStampList(LinkedList<Long> accessTimeStampList) {
            this.accessTimeStampList = accessTimeStampList;
        }


        /**
         * 是否热点数据
         *
         * @return
         */
        public boolean isHotData() {
            //判断是否热点数据，500ms内被访问3次才会认为是热点数据。
            if (accessTimeStampList.size() < ACCESS_COUNT_THRESHOLD) {
                return false;
            }
            return accessTimeStampList.get(ACCESS_COUNT_THRESHOLD - 1) - accessTimeStampList.get(0) <= EXPIRATION_INTERVAL;
        }

        /**
         * 是否超时，惰性删除
         *
         * @return
         */
        public boolean isTimeout() {
            return System.currentTimeMillis() >= expireTime;
        }

        /**
         * 增加访问记录，最多3个
         *
         * @param timeMillis
         */
        public void addAccessTimeStamp(long timeMillis) {
            accessTimeStampList.add(timeMillis);
            if (accessTimeStampList.size() > ACCESS_COUNT_THRESHOLD) {
                accessTimeStampList.removeFirst();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        LRUHotData lruHotData = new LRUHotData();
        new Thread(lruHotData).start();

        System.out.println(lruHotData.getData("a"));
        Thread.sleep(300);
        System.out.println(lruHotData.getData("a"));
        Thread.sleep(200);
        System.out.println(lruHotData.getData("a"));
        Thread.sleep(100);
        System.out.println(lruHotData.getData("a"));
        Thread.sleep(100);
        System.out.println(lruHotData.getData("a"));
        System.out.println(lruHotData.getData("a"));
    }
}
