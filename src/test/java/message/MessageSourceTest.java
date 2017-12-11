package message;

import org.junit.Test;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author yaojiafeng
 * @create 2017-12-08 下午4:16
 */
public class MessageSourceTest {
    @Test
    public void getMessage() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);

        String message = messageSource.getMessage("system.unknown.exception", null, "异常", Locale.SIMPLIFIED_CHINESE);
        System.out.println(message);

        message = messageSource.getMessage("system.unknown.exception", null, "异常", Locale.US);
        System.out.println(message);
    }
}
