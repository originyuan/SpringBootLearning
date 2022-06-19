package cc.yuanspace.springboot.kafka.producer.mq;

import cc.yuanspace.springboot.kafka.producer.constant.MqConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class MqService {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String send(Map<String, Object> msg){
        String msgValue = null;
        try {
            msgValue = om.writeValueAsString(msg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(MqConstant.TEST_TOPIC, msgValue);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("消息发送失败", ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("消息发生成功 result:{}", result.toString());
            }
        });
//        try {
//            SendResult<String, String> result = future.get();// 同步等待结果
//            return result.toString();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        return "success";
    }
}
