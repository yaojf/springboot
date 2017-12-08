package time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author yaojiafeng
 * @create 2017-10-10 上午10:50
 */
public class DateTimeFormatterTest {

    @Test
    public void format() {
        String format = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(format);

        LocalDateTime of = LocalDateTime.of(9999, 12, 31, 23, 59, 59);
         Date FOREVER_DATE = Date.from(of.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(FOREVER_DATE);
    }

}
