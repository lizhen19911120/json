import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by lizhen on 2018/9/21.
 */

/**
 * @JsonRootName
 * 指定形如以下json格式，实体类json有根名字的时候的root name，配合SerializationFeature.WRAP_ROOT_VALUE使用。这里是Labels，默认是实体类名
 *        {
          "Labels": {
                     "com.prop.vendor": "Acme",
                     "com.example.license": "GPL",
                     "com.example.version": "1.0"
                    }
          }

 */
@JsonRootName("myJSON")
public class TestDomain extends FatherDomain{
    /**
     * @JsonIgnore
     * 序列化/反序列化时忽略此属性，只能使用在简单基础属性上？
     */
    @JsonIgnore
    private String id;


    /**
     * @JsonSerialize
     * 指定序列化时参数的处理细节，jackson使用ObjectMapper来进行转换
     */
//    @JsonSerialize(using=DateJsonSerializer.class)
    /**
     * @JsonDeserialize
     * 指定反序列化时参数的处理细节，jackson使用ObjectMapper来进行转换
     */
//    @JsonDeserialize(using=DateJsonDeserializer.class)
    /**
     *
     * 指定序列化/反序列化的细节，本身没有作用，依据注解的字段属性和使用的deserializer/serializer发挥作用
     * @JsonFormat
     * jsr310包内置的deserializer/serializer
     * @LocalDateTimeDeserializer
     * @LocalDateTimeSerializer
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    /**
     * 不是Jackson里的注解，而是spring自带的格式化注解，主要作用是在web应用中将前端发送的符合格式的请求参数
     * 转为对应的时间类接收，同时配合jsp将返回给前端的时间对象转为对应格式的文本
     * @DateTimeFormat
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cmamCreateTime;
    @JsonSerialize(using=DateJsonSerializer1.class)
    @JsonDeserialize(using=DateJsonDeserializer1.class)
    private LocalDate cmamEra;
    @JsonSerialize(using=DateJsonSerializer1.class)
    @JsonDeserialize(using=DateJsonDeserializer1.class)
    private LocalDate cmamYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCmamCreateTime() {
        return cmamCreateTime;
    }

    public LocalDate getCmamEra() {
        return cmamEra;
    }

    public LocalDate getCmamYear() {
        return cmamYear;
    }

    public void setCmamCreateTime(LocalDateTime cmamCreateTime) {
        this.cmamCreateTime = cmamCreateTime;
    }

    public void setCmamEra(LocalDate cmamEra) {
        this.cmamEra = cmamEra;
    }

    public void setCmamYear(LocalDate cmamYear) {
        this.cmamYear = cmamYear;
    }


}
