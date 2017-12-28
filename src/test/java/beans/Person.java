package beans;

import javax.validation.constraints.NotNull;

/**
 * @author yaojiafeng
 * @create 2017-09-25 下午3:02
 */
public class Person {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
