package cc.yuanspace.springboot.integration.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cc.yuanspace.springboot.integration.mybatis.**.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("*************启动成功***********************");
    }
}
