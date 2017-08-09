import com.alibaba.fastjson.JSON;
import com.yaojiafeng.springboot.domain.City;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author yaojiafeng
 * @create 2017-06-28 下午2:29
 */
public class HttpTest {

    @Test
    public void testSaveCity() throws IOException {
        //创建URL
        StringBuffer buffer = new StringBuffer(); //用来拼接参数
        StringBuffer result = new StringBuffer(); //用来接受返回值
        URL httpUrl = null; //HTTP URL类 用这个类来创建连接
        HttpURLConnection connection = null; //创建的http连接
        PrintWriter printWriter = null;
        BufferedReader bufferedReader; //接受连接受的参数
        //创建URL
        httpUrl = new URL("http://localhost:8080/api/city");
        //建立连接
        connection = (HttpURLConnection) httpUrl.openConnection();
        connection.setRequestProperty("accept", "*");
        connection.setRequestProperty("connection", "keep-alive");
        connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");//设置post请求
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.connect();


        printWriter = new PrintWriter(connection.getOutputStream());

        City city = new City();
        city.setId(1L);
        city.setProvinceId(2L);
        city.setCityName("nima");

        buffer.append(JSON.toJSONString(city));

        printWriter.print(buffer.toString());
        printWriter.flush();

        //接受连接返回参数
        bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        bufferedReader.close();

        System.out.println(result.toString());
    }


}
