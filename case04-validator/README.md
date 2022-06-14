### 参数校验

> 校验参数在项目中是很常见的，在java中，几乎每个有入参的方法，在执行下一步操作之前，都要验证参数的合法性，比如是入参否为空，数据格式是否正确等等，往常的写法就是一大推的if-else,既不美观也不优雅，这个时候JCP组织站出来了，并且制定了一个标准来规范校验的操作，这个标准就是Java Validation API(JSR 303)  
>  


接口
```xml
<!-- api改名了，原先为javax.validaion>>validation-api -->
<dependency>
    <groupId>jakarta.validation</groupId>
    <artifactId>jakarta.validation-api</artifactId>
    <version>2.0.2</version>
</dependency>
```

两个实现：  
第一个hibernate  
提供了 @Valid 注解，可以校验对象参数，但是无法处理单个参数
```xml
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>7.0.1.Final</version>
</dependency>

```
第二个实现，spring-boot-starter-validation  
是对hibernate-validator的封装  
提供了 @Validated 注解，可以校验对象参数，方法单个参数，分组校验
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

通过使用@NotNull等注解配合@Valid或@Validated注解，可以快速实现参数校验  

推荐使用 `validation-api` 中的注解，不推荐`hibernate-validator`中独有的注解，不具有泛用性  



用法示例：    
@Valid @Validated标记方法参数    
1、方法单参数  
这种方式不需要标记 @Valid @Validated  
function(@NotNull paramter)   


2、对象参数  
function(@Valied object)    

3、嵌套校验  

4、分组校验   

5、BindResult   

6、编程式校验--Validator对象  

7、自定义注解和校验规则  


@Valid @Validated 标记对象   

