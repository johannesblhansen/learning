package dk.johannes.basic_kafka_producer;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class KafkaValuesConfig {
    @Value("${bootstrap.address}")
    private String bootstrapAddress;
}
