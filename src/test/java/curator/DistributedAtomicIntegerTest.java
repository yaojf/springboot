package curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.RetryNTimes;

/**
 * 分布式计数器
 *
 * @author yaojiafeng
 * @create 2018-01-22 上午11:16
 */
public class DistributedAtomicIntegerTest {
    private static final String ZK_ADDRESS = "127.0.0.1:2181";

    public static void main(String[] args) throws Exception {
        CuratorFramework zk = CuratorFrameworkFactory.builder()
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryNTimes(3, 1000))
                .connectionTimeoutMs(50000)
                .connectString(ZK_ADDRESS)
                .build();
        zk.start();
        //分布式计数器
        DistributedAtomicInteger counter = new DistributedAtomicInteger(zk, "/super", new RetryNTimes(3, 100));
        //初始化
        //counter.forceSet(0);
        AtomicValue<Integer> value = counter.increment();
        System.out.println("原值为" + value.preValue());
        System.out.println("更改后的值为" + value.postValue());
        System.out.println("状态" + value.succeeded());
    }
}
