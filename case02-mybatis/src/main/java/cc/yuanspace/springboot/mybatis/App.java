package cc.yuanspace.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cc.yuanspace.springboot.mybatis.**.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("*************启动成功***********************");
    }
}
