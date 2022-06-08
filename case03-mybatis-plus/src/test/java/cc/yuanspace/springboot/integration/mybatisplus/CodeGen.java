package cc.yuanspace.springboot.integration.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 代码生成
 */
@SpringBootTest
public class CodeGen {
    // 是否使用lombok标记实体类
    boolean enableLombok = false;
    // 表面的前缀，生成类时会自动移除
    String tableNamePrefix = "t_";
    // 要生成的表名，与数据库一致，不存在的表会在控制台打印警告
    String[] tables = {
            "t_order", "t_order_item"
    };

    @Test
    public void execGen() {

        // 代码生成器
        AutoGenerator generatorConfig = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 获取项目根路径：D:\Code\SpringBootIntegration\case03-mybatis-plus
        String projectPath = System.getProperty("user.dir");
        // 生成文件的输出目录，输出到/target目录下，不影响现有代码
        globalConfig.setOutputDir(projectPath + "/target/script");
        // 开发人员
        globalConfig.setAuthor("yy");
        // 是否自动打开输出目录
        globalConfig.setOpen(false);
        // 主键生成策略
//        globalConfig.setIdType(IdType.AUTO);
        // 覆盖已生成文件
        globalConfig.setFileOverride(true);
        // 生成resultMap
        globalConfig.setBaseResultMap(true);
        // 在xml中生成基础列
        globalConfig.setBaseColumnList(true);
        // 生成的service接口名字格式
        globalConfig.setServiceName("I%sService");
        // 默认是LocalDateTime 注释打开可以修改成Date
//        globalConfig.setDateType(DateType.ONLY_DATE);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 数据源设置mysql类型
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/training?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");


        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 开启全局大写命名
        strategyConfig.setCapitalMode(true);
        // 下划线到驼峰的命名方式
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 表名字段名使用下划线
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 表名前缀
        strategyConfig.setTablePrefix(tableNamePrefix);
        // 使用lombok
        strategyConfig.setEntityLombokModel(enableLombok);
        // 需要包含的表
        strategyConfig.setInclude(tables);
        // 排除的表
        strategyConfig.setExclude();

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("cc.yuanspace.springboot.integration.mybatisplus");
        packageConfig.setMapper("mapper"); // xxxMapper文件的包
        packageConfig.setEntity("entity"); // 实体类文件的包
        packageConfig.setXml("mapper.xml");    // xml文件生成路径
        packageConfig.setService("service"); // service相关接口和实现类的包
        packageConfig.setController("controller"); // controller的包


        generatorConfig.setGlobalConfig(globalConfig);
        generatorConfig.setDataSource(dataSourceConfig);
        generatorConfig.setStrategy(strategyConfig);
        generatorConfig.setPackageInfo(packageConfig);
        generatorConfig.execute();


        System.out.println("**********代码生成结束********");
    }
}
