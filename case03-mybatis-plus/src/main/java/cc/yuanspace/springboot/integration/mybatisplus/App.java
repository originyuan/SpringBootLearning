package cc.yuanspace.springboot.integration.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cc.yuanspace.springboot.integration.mybatisplus.**.mapper") // 开启mapper包扫描
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("启动成功");
    }
}
