package cc.yuanspace.springboot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

// 开启异步任务
@EnableAsync
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("***** 启动成功 *************");
    }

}
