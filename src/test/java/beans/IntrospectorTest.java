package beans;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yaojiafeng
 * @create 2017-09-25 下午2:58
 */
public class IntrospectorTest {

    /**
     * PropertyDescriptor依赖字段的set和get方法
     * 没有对应的set和get方法则没有对应的read和write方法
     *
     * 依赖于set和get方法，跟具体的字段名没关系
     *
     * @throws IntrospectionException
     */
    @Test
    public void testPropertyDescriptors() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            if (pd.getName().equals("class")) {
                continue;
            }
            System.out.println(pd.getName());
            System.out.println(pd.getReadMethod());
            System.out.println(pd.getWriteMethod());
            System.out.println("********");
        }
    }

}
