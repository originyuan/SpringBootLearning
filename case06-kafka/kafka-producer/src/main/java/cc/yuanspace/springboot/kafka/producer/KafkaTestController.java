package cc.yuanspace.springboot.kafka.producer;

import cc.yuanspace.springboot.kafka.producer.mq.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KafkaTestController {

    @Autowired
    private MqService mqService;

    @PostMapping("/send")
    public String send(@RequestBody Map<String,Object> msg) {
        System.out.println(msg);
        return mqService.send(msg);
    }

}
