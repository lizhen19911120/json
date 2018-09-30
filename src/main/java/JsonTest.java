import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by lizhen on 2018/9/13.
 */
public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         * 指定序列化/反序列化时是否有root name。
         */
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
//        objectMapper.setSerializerFactory()
        TestDomain domain = new TestDomain();
        domain.setCmamCreateTime(LocalDateTime.now());
        domain.setCmamEra(LocalDateTime.now().toLocalDate());
        domain.setCmamYear(LocalDateTime.now().toLocalDate());

        System.out.println(objectMapper.writeValueAsString(domain));

        try {
            TestDomain testDomain = objectMapper.readValue("{\"myJSON\":{\"id\":\"111111\",\"cmamCreateTime\":\"2018-09-25 18:03:58\",\"cmamEra\":\"2018-09-27\",\"cmamYear\":\"2018-10-01\",\"myName\":\"lizhen\",\"ageSetter\":\"28\"}}",TestDomain.class);
            System.out.println(testDomain.getId());
            System.out.println(testDomain.getCmamCreateTime());
            System.out.println(testDomain.getCmamEra());
            System.out.println(testDomain.getCmamYear());
            System.out.println(testDomain.getName());
            System.out.println(testDomain.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
