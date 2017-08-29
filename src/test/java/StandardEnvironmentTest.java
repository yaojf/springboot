import org.junit.Test;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author yaojiafeng
 * @create 2017-08-29 下午3:22
 */
public class StandardEnvironmentTest {

    /**
     * 环境的作用递归解析配置key
     */
    @Test
    public void resolvePlaceholders() {
        StandardEnvironment standardEnvironment = new StandardEnvironment();
        String property = standardEnvironment.getProperty("regCenter.serverList");
        System.out.println(property);
    }

}
