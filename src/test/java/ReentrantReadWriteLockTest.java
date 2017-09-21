import org.junit.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yaojiafeng
 * @create 2017-09-06 下午8:14
 */
public class ReentrantReadWriteLockTest {

    @Test
    public void test(){
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        readLock.lock();

        new Thread(()-> {
            readLock.lock();
            readLock.unlock();
        }).start();

        new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            writeLock.lock();
            writeLock.unlock();
        }).start();


        readLock.unlock();
    }



}
