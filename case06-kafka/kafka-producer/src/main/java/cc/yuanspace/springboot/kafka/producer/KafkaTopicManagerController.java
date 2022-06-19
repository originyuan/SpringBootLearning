package cc.yuanspace.springboot.kafka.producer;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/admin")
public class KafkaTopicManagerController {
    @Autowired
    private AdminClient adminClient;

    @GetMapping("/getTopic")
    public List<String> getTopics() throws ExecutionException, InterruptedException {
        ListTopicsResult topics = adminClient.listTopics();
        return new ArrayList<>(topics.names().get());
    }
}
