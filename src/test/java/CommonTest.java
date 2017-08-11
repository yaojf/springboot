import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Data;
import org.junit.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yaojiafeng
 * @create 2017-07-13 上午11:29
 */
public class CommonTest {

    @Data
    static class Point {
        Long x;
        Long y;

        public Point(Long x, Long y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void sum() {
        List<Point> list = new ArrayList<>();
        list.add(new Point(1L, 1L));
        list.add(new Point(null, 1L));
        list.add(new Point(2L, 2L));

        long sum = list.stream().mapToLong(Point::getX).sum();

        System.out.println(sum);
    }


    @Test
    public void json() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JsonGenerator generator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        ObjectWriter objectWriter = objectMapper.writer();

        objectWriter.writeValue(generator, new Point(null,1L));

        generator.flush();
    }


    @Test
    public void test(){

        System.out.println(futureDate(1, TimeUnit.HOURS));
    }

    public static Date futureDate(long value, TimeUnit timeUnit) {
        Assert.notNull(timeUnit);
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = null;
        if (timeUnit == TimeUnit.DAYS) {
            futureDateTime = localDateTime.plusDays(value);
        } else if (timeUnit == TimeUnit.HOURS) {
            futureDateTime = localDateTime.plusHours(value);
        } else if (timeUnit == TimeUnit.MINUTES) {
            futureDateTime = localDateTime.plusMinutes(value);
        } else if (timeUnit == TimeUnit.SECONDS) {
            futureDateTime = localDateTime.plusSeconds(value);
        } else {
            throw new IllegalArgumentException("不支持的时间单位");
        }

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = futureDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }
}
