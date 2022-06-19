package cc.yuanspace.springboot.kafka.consumer.mq;

import cc.yuanspace.springboot.kafka.consumer.constant.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class KafkaMqConsumer {

    @KafkaListener(topics = MqConstant.TEST_TOPIC, groupId = MqConstant.GROUP_ID)
    public void consume(ConsumerRecord<String, String> record, Acknowledgment ack) {
        log.info("mq-consumer at {}  topic:{} partition:{} value:{}  time:{}", LocalDateTime.now(),
                record.topic(), record.partition(), record.value(), record.timestamp());
        ack.acknowledge();
    }
}
