package cc.yuanspace.springboot.validator.anno;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsABCValidator implements ConstraintValidator<IsABC, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            return "abc".equalsIgnoreCase(value);
        }
        return false;
    }
}
