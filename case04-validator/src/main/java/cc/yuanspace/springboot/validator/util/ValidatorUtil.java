package cc.yuanspace.springboot.validator.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

public class ValidatorUtil {
    private static Validator validator;

    public ValidatorUtil(Validator validator) {
        ValidatorUtil.validator = validator;
    }

    public static Set<String> valid(Object obj) {
        // 执行校验 返回
        Set<ConstraintViolation<Object>> violationSet = validator.validate(obj);
        Set<String> res = new HashSet<>();
        for (ConstraintViolation<Object> constraintViolation : violationSet) {
            // 错误描述
            String message = constraintViolation.getMessage();
            // 当前值
            Object invalidValue = constraintViolation.getInvalidValue();
            res.add(message + " current value is [" + invalidValue + "]");
        }
        return res;
    }
}
