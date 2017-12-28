package classloader;

/**
 * @author yaojiafeng
 * @create 2017-12-19 上午11:05
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.err.println(Thread.currentThread().getContextClassLoader());
    }
}
