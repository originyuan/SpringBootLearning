package cc.yuanspace.springboot.es.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsApp {
    public static void main(String[] args) {
        SpringApplication.run(EsApp.class, args);

        System.out.println("***** 运行成功 ************");
    }
}
