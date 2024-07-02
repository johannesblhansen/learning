package dk.johannes.basic_kafka_producer;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostStartupSender implements ApplicationListener<ContextRefreshedEvent> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PostStartupSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        kafkaTemplate.send("topicNumber2", "someMessage2");
    }
}
