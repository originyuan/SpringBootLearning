package cc.yuanspace.springboot.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidatorApp {
    public static void main(String[] args) {
        SpringApplication.run(ValidatorApp.class, args);

        System.out.println("******启动成功************");
    }
}
