package cc.yuanspace.springboot.validator.controller;

import cc.yuanspace.springboot.validator.vo.GroupValidVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/group")
public class GroupValidController {

    ObjectMapper om = new ObjectMapper();

    @PostMapping("/valid")
    public String valid(@RequestBody @Valid GroupValidVO vo) throws JsonProcessingException {
        return om.writeValueAsString(vo);
    }
    @PostMapping("/validated")
    public String validated(@RequestBody @Validated GroupValidVO vo) throws JsonProcessingException {
        return om.writeValueAsString(vo);
    }

    @PostMapping("/validGroup1")
    public String validGroup1(@RequestBody @Validated(value = GroupValidVO.Group1.class) GroupValidVO vo) throws JsonProcessingException {
        return om.writeValueAsString(vo);
    }

    @PostMapping("/validGroup2")
    public String validGroup2(@RequestBody @Validated(value = GroupValidVO.Group2.class) GroupValidVO vo) throws JsonProcessingException {
        return om.writeValueAsString(vo);
    }
}
