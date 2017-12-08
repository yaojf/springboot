package thread;

import java.time.LocalDateTime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yaojiafeng
 * @create 2017-09-30 下午5:10
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 8, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        threadPoolExecutor.submit(() -> System.out.println(LocalDateTime.now()));
    }
}
