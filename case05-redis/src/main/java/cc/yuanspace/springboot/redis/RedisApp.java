package cc.yuanspace.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApp {

    public static void main(String[] args) {
        SpringApplication.run(RedisApp.class, args);

        System.out.println("***** run success ************");
    }
}
