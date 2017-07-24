import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Data;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

}
