package cc.yuanspace.springboot.validator;

import cc.yuanspace.springboot.validator.util.ValidatorUtil;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SpringBootApplication
public class ValidatorApp {
    public static void main(String[] args) {
        SpringApplication.run(ValidatorApp.class, args);

        System.out.println("******启动成功************");
    }

    //@Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败模式
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    @Bean
    public ValidatorUtil validatorUtil(Validator validator) {
        return new ValidatorUtil(validator);
    }
}
