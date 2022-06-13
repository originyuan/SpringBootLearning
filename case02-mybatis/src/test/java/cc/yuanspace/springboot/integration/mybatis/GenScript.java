package cc.yuanspace.springboot.integration.mybatis;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GenScript {

    @Test
    public void genCode() throws Exception {

        List<String> warnings = new ArrayList<>();
        InputStream is = GenScript.class.getClassLoader().getResource("gen-config.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        System.out.println("********************代码已生成*****************************");
    }
}
