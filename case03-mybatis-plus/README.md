整合mybatis-plus

主要依赖：
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.4.3</version>
</dependency>
<!--        代码生成器-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.4.1</version>
</dependency>
<!-- mybatisplus逆向工程需要模板引擎，用freemaker也行 -->
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.0</version>
</dependency>
```

application.yml 配置：
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/training?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8
    username: root
    password: 123456
    
mybatis-plus:
  # mapper文件的路径
  mapper-locations: classpath*:/META-INF/mapper/*.xml
  global-config:
    db-config:
      id-type: auto
#      tablePrefix: t_
  configuration:
    cache-enabled: false
```
如果不需要druid连接池的话，这些配置就够连接
