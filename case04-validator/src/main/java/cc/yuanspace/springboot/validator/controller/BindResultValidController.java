package cc.yuanspace.springboot.validator.controller;

import cc.yuanspace.springboot.validator.vo.CustomValidVO;
import cc.yuanspace.springboot.validator.vo.ValidVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/bindResult")
public class BindResultValidController {
    ObjectMapper om = new ObjectMapper();

    /**
     * 由于类上标注了@Validated，所以这里必须使用@Validated，否则就抛出ConstraintViolationException异常
     * 而不是封装到BindingResult对象中
     */
    @PostMapping("/valid")
    public Map<String, Object> valid(@RequestBody @Validated ValidVO vo, BindingResult bindingResult) throws JsonProcessingException {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : allErrors) {
            sb.append(error.getDefaultMessage()).append(";");
        }
        Map<String, Object> res = new HashMap<>();
        res.put("errmsg", sb.toString());
        return res;
    }

    /**
     * 这种不支持BindingResult 异常被抛出了
     */
    @GetMapping("/validFun")
    public Map<String, Object> validFun(@NotNull(message = "[name]参数不能为空") String name, BindingResult bindResult) throws JsonProcessingException {
        System.out.println(name);
        System.out.println(bindResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()));
        return new HashMap<>();
    }
}
