package condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yaojiafeng
 * @create 2017-09-05 下午4:18
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();

        Object config = context.getBean("config");
        System.out.println(config);


    }
}
