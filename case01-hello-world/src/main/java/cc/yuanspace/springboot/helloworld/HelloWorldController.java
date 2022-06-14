package cc.yuanspace.springboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/get")
    public String get() {
        return "getxxxxx";
    }
}
