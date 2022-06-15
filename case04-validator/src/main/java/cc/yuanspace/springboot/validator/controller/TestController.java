package cc.yuanspace.springboot.validator.controller;

import cc.yuanspace.springboot.validator.util.ValidatorUtil;
import cc.yuanspace.springboot.validator.vo.NoValidVO;
import cc.yuanspace.springboot.validator.vo.ValidVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    private static final ObjectMapper om = new ObjectMapper();

    @PostMapping("/validatorUtil")
    public Object validatorUtil(@RequestBody ValidVO vo) throws JsonProcessingException {
        return ValidatorUtil.valid(vo);
    }

    @PostMapping("/novalid")
    public String novalid(@RequestBody NoValidVO nv) throws JsonProcessingException {
        System.out.println(om.writeValueAsString(nv));

        return om.writeValueAsString(nv);
    }

    @PostMapping("/valid")
    public ValidVO valid(@RequestBody @Valid ValidVO nv) throws JsonProcessingException {
        System.out.println(om.writeValueAsString(nv));
        System.out.println(om.readValue(om.writeValueAsString(nv), ValidVO.class));
        return nv;
    }

    @PostMapping("/validated")
    public String validated(@RequestBody @Validated ValidVO nv) throws JsonProcessingException {
        System.out.println(om.writeValueAsString(nv));

        return om.writeValueAsString(nv);
    }
}
