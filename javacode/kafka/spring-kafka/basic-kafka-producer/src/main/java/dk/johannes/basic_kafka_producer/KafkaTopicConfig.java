package dk.johannes.basic_kafka_producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class KafkaTopicConfig {
//    String bootstrapAddress = "https://kafka-0:9092"; //This works from inside the same docker network as kafka-0 container
//    String bootstrapAddress = "https://localhost:9093"; //Works from the new setup with external working


    private final KafkaValuesConfig kafkaValuesConfig;

    public KafkaTopicConfig(KafkaValuesConfig kafkaValuesConfig) {
        this.kafkaValuesConfig = kafkaValuesConfig;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaValuesConfig.getBootstrapAddress());
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        System.out.println("Topic number 2 is added");
        return new NewTopic("topicNumber2", 1, (short) 1);
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        log.info("Using bootstrap server: {}", kafkaValuesConfig.getBootstrapAddress());
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaValuesConfig.getBootstrapAddress());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
