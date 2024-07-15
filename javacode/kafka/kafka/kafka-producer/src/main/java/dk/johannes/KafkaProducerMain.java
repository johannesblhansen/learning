package dk.johannes;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class KafkaProducerMain {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerMain.class.getSimpleName());
    public static void main(String[] args) {
        log.info("Hello {}", "Johannes");

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "https://localhost:9093");

        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        ProducerRecord<String, String> stringStringProducerRecord = new ProducerRecord<>("johannestopic", "Hello From Straight Java Producer 2");

        producer.send(stringStringProducerRecord);

        producer.flush();

        producer.close();
    }
}