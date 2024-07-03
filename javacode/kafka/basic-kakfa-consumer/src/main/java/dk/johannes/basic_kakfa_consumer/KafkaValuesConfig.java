package dk.johannes.basic_kakfa_consumer;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class KafkaValuesConfig {
    @Value("${bootstrap.address}")
    private String bootstrapAddress;
}
