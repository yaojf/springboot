package component;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

/**
 * Created by yaojiafeng on 2017/5/17 下午5:50.
 */
@Data
@Component
public class City {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    @NotBlank(message = "城市名称不能为空")
    private String cityName;

    /**
     * 描述
     */
    private String description;

    public City() {
    }

    public City(Long id, Long provinceId, String cityName, String description) {
        this.id = id;
        this.provinceId = provinceId;
        this.cityName = cityName;
        this.description = description;
    }
}
