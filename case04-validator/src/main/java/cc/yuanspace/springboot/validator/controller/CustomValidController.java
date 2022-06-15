package cc.yuanspace.springboot.validator.controller;

import cc.yuanspace.springboot.validator.vo.CustomValidVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/custom")
public class CustomValidController {

    @PostMapping("/valid")
    public String valid(@RequestBody @Valid CustomValidVO vo) {
        return vo.getAbc();
    }




}
