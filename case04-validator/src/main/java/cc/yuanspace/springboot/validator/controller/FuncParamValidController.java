package cc.yuanspace.springboot.validator.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/funcParam")
public class FuncParamValidController {
    @PostMapping("/valid")
    public String validFunParam(@NotNull(message = "[name]参数不能为空") String name) {
        return "valid success " + name;
    }
}
