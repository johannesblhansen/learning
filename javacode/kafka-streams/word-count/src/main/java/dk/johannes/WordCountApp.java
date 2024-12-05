package dk.johannes;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class WordCountApp {
    public static void main(String[] args) {
        System.out.println("Hello There");

        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, String> inputStream = streamsBuilder.stream("streams-plaintext-input", Consumed.with(Serdes.String(), Serdes.String()));
        inputStream.peek((key, value) -> {
            System.out.println("Got Something: " + key + " - " + value);
        });

        KStream<String, String> stringStringKStream = inputStream
                .mapValues(value -> value.toLowerCase())
                .flatMapValues(value -> List.of(value.split(" ")))
                .selectKey((key, value) -> value); //Note this operation changes the key. When the key is changed, Kafka streams will create a repartition topic.

        KGroupedStream<String, String> stringStringKGroupedStream = stringStringKStream.groupByKey();
        KTable<String, Long> countTable = stringStringKGroupedStream.count(Named.as("TheCountTable"), Materialized.with(Serdes.String(), Serdes.Long()));

        KStream<String, Long> stream = countTable.toStream();
        stream.peek((key, value) -> {
            System.out.println("After the count: " + key + " - " + value);
        });
        stream.to("streams-wordcount-output", Produced.with(Serdes.String(), Serdes.Long()));


        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), getProps());
        final CountDownLatch latch = new CountDownLatch(1);

        try {
            kafkaStreams.start();
            latch.await();
        } catch (InterruptedException e) {
            kafkaStreams.close();
        }

    }


    private static Properties getProps() {
        Properties properties = new Properties();
        properties.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "johannes-stream");
        properties.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
        properties.putIfAbsent(StreamsConfig.STATESTORE_CACHE_MAX_BYTES_CONFIG, 0);
        properties.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class);
        properties.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.StringSerde.class);
        return properties;
    }
}