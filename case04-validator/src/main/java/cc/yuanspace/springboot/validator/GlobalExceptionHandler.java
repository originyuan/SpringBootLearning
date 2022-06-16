package cc.yuanspace.springboot.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> constraintViolationExceptionHandle(ConstraintViolationException e) {
        log.error("ConstraintViolationException", e);
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> violation : constraintViolations) {
            String message = violation.getMessage();
            Object invalidValue = violation.getInvalidValue();
            sb.append(message).append(":").append(invalidValue).append("\n");
        }
        Map<String, Object> r = new HashMap<>();
        r.put("errcode", 1);
        r.put("errmsg", sb.toString());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> MethodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        // MethodArgumentNotValidException 异常 需要从BindingResult中提取错误信息
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : bindingResult.getAllErrors()) {
            sb.append(error.getDefaultMessage()).append(";");
        }
        Map<String, Object> r = new HashMap<>();
        r.put("errcode", 1);
        r.put("errmsg", sb.toString());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

     @ExceptionHandler(value = Exception.class)
     public ResponseEntity<Map<String, Object>> exceptionHandle(Exception e) {
         log.error("exception", e);

         Map<String, Object> r = new HashMap<>();
         r.put("errcode", 1);
         r.put("errmsg", "系统繁忙，请稍后重试！");
         return new ResponseEntity<>(r, HttpStatus.OK);
     }
}
