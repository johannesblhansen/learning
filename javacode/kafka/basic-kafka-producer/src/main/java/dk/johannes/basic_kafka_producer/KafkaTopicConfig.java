package dk.johannes.basic_kafka_producer;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
//        String bootstrapAddress = "https://kafka-0:9092"; //This works from inside the same docker network as kafka-0 container
        String bootstrapAddress = "https://localhost:9093"; //Works from the new setup with external working
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        System.out.println("Topic number 2 is added");
        return new NewTopic("topicNumber2", 1, (short) 1);
    }
}
