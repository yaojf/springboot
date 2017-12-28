import com.yaojiafeng.springboot.domain.City;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.junit.Test;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * 参数验证代码测试
 *
 * @author yaojiafeng
 * @create 2017-09-04 上午10:59
 */
public class ValidatorImplTest {


    /**
     * 对象校验
     */
    @Test
    public void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        City city = new City();
        Set<ConstraintViolation<City>> validate = validator.validate(city);
        System.out.println(validate);
        city.setCityName("nima");
        validate = validator.validate(city);
        System.out.println(validate);
    }


    /**
     * 方法参数校验
     *
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    @Test
    public void hibernateVaildTest() throws NoSuchMethodException, SecurityException {
        // 需要校验的方法实例
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ExecutableValidator validator = factory.getValidator().forExecutables();

        Method method = this.getClass().getMethod("vaildMethod", Integer.class, String.class, String.class);
        // 校验参数，应该是有两个非法的参数
        Object[] params = new Object[]{100, "", "test"};

        // 获得校验结果 Set 集合，有多少个字段校验错误 Set 的大小就是多少
        Set<ConstraintViolation<ValidatorImplTest>> constraintViolationSet =
                validator.validateParameters(this, method, params);

        System.out.println("非法参数校验结果条数: " + constraintViolationSet.size());
        constraintViolationSet.forEach(cons -> {
            System.out.println("非法消息: " + cons.getMessage());
        });

        params = new Object[]{10, "build-test", "test"};
        constraintViolationSet =
                validator.validateParameters(this, method, params);

        System.out.println("合法参数校验结果条数: " + constraintViolationSet.size());
    }

    // 校验示范方法
    // @Valid注解也可以识别
    public void vaildMethod(@NotNull @Range(min = 0, max = 18) Integer age, @NotBlank String build, String test) {

    }

}
