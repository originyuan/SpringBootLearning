package cc.yuanspace.springboot.integration.mybatisplus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
public class AppTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test () {
        System.out.println("test");
        System.out.println(dataSource.getClass());
        // druid的数据源
        // class com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper
    }
}
