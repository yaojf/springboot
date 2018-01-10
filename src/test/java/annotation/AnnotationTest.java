package annotation;

import org.junit.Test;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author yaojiafeng
 * @create 2018-01-05 下午2:18
 */
@PropertySource(value = "a")
@PropertySource(value = "b")
public class AnnotationTest {

    /**
     * 重复注解的使用
     */
    @Test
    public void repeatable() {
        PropertySources propertySources = AnnotationTest.class.getAnnotation(PropertySources.class);
        System.err.println(propertySources.value()[1].value()[0]);

        PropertySource[] sources = AnnotationTest.class.getAnnotationsByType(PropertySource.class);
        System.err.println(sources[0].value()[0]);
    }
}
