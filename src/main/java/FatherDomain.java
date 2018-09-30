import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by lizhen on 2018/9/27.
 */
public class FatherDomain {
    /**
     * 指定序列化/反序列化时json字符串对应属性字段的名称，这里就是类中的name对应json中的myName
     */
    @JsonProperty(value = "myName")
    private String name;

    private Integer age;
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 反序列化，即json转为实体类时，json字符串对应属性字段的名称
     * @JsonSetter
     */
    @JsonSetter("ageSetter")
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    /**
     * 序列化，即实体类转为json时，json字符串对应属性字段的名称
     * @JsonGetter
     */
    @JsonGetter("ageGetter")
    public Integer getAge() {
        return age;
    }
}
