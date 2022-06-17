package cc.yuanspace.springboot.redis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper om = new ObjectMapper();

    public static String toJsonStr(Object obj) {
        try {
            return om.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("om.writeValueAsString err ", e);
        }
        return null;
    }

    public static <T> T parse(String jsonStr, Class<T> valueType) {
        try {
            return om.readValue(jsonStr, valueType);
        } catch (JsonProcessingException e) {
            log.error("om.writeValueAsString err ", e);
        }
        return null;
    }
}
