package cc.yuanspace.springboot.validator.controller;

import cc.yuanspace.springboot.validator.vo.NestedValidVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/nested")
public class NestedValidController {

    ObjectMapper om = new ObjectMapper();

    @PostMapping("/valid")
    public NestedValidVO valid(@RequestBody @Valid NestedValidVO vo) throws JsonProcessingException {

        System.out.println(om.writeValueAsString(vo));
        return vo;
    }

    @PostMapping("/validated")
    public NestedValidVO validated(@RequestBody @Validated NestedValidVO vo) throws JsonProcessingException {

        System.out.println(om.writeValueAsString(vo));
        return vo;
    }
}
