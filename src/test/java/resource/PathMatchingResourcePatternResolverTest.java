package resource;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author yaojiafeng
 * @create 2018-01-10 下午8:26
 */
public class PathMatchingResourcePatternResolverTest {
    @Test
    public void getResources() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
        Resource[] resources = resolver.getResources("classpath:/*.properties");
        for (Resource resource : resources) {
            String mapping = Resources.toString(resource.getURL(), Charsets.UTF_8);
            System.err.println(mapping);
        }
    }
}
