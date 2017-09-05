import com.yaojiafeng.springboot.domain.City;
import org.junit.Test;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * 参数验证代码测试
 *
 * @author yaojiafeng
 * @create 2017-09-04 上午10:59
 */
public class ValidatorImplTest {


    @Test
    public void validate() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        factoryBean.afterPropertiesSet();
        City city = new City();
//        city.setCityName("nima");
        Set<ConstraintViolation<City>> validate = factoryBean.validate(city);

        System.out.println(validate);
    }

}
