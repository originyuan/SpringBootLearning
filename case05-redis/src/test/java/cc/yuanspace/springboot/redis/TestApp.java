package cc.yuanspace.springboot.redis;

import cc.yuanspace.springboot.redis.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TestApp {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void set() {
        redisUtil.set("哈哈", "呵呵");
        Object o = redisUtil.get("哈哈");
        System.out.println(o);
    }

    @Test
    public void setObj() {
        Map<String, String> map = new HashMap<>();
        map.put("tpm", "滴滴答答");
        map.put("ccccc", "ggfs");
//        redisUtil.set("拉拉", map);
        Object o = redisUtil.get("拉拉");

        System.out.println(o.getClass());
        // 可以这么转
        Map<String, String> map1 = (Map<String, String>) redisUtil.get("拉拉");
        System.out.println(map1);
    }

    @Test
    public void test() {
        Object o = redisUtil.get("123");
        System.out.println(o);
    }
}
