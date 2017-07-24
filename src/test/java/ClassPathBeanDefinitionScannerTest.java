import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @author yaojiafeng
 * @create 2017-07-24 下午2:38
 */
public class ClassPathBeanDefinitionScannerTest {

    /**
     * 默认不会扫描到接口
     */
    @Test
    public void testScan() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(defaultListableBeanFactory, true);
        scanner.scan("com.yaojiafeng.springboot.dao");
        System.out.println(defaultListableBeanFactory.getBeanDefinitionCount());
    }
}
