package condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author yaojiafeng
 * @create 2017-09-05 下午4:12
 */
@Configuration("config")
@Conditional(ConditionImpl.class)
public class Config {

    @Bean("String")
    public String createString() {
        System.out.println("======000");
        return "String";
    }

}