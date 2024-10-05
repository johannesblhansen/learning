package dk.johannes;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        StreamsBuilder builder = new StreamsBuilder();
        Serde<String> stringSerde = Serdes.serdeFrom(String.class);

        KStream<String, String> myStream = builder.stream("johannestopic", Consumed.with(stringSerde, stringSerde));
        myStream
                .peek((key, value) -> {
                    System.out.println("Hello here is the key and value: " + key + " - " + value);
                })
                .mapValues(s -> s.toUpperCase())
                .peek((key, value) -> {
                    System.out.println("Hello here is the key and value: " + key + " - " + value);
                })
                .to("johannesoutput", Produced.with(stringSerde, stringSerde));


        final KafkaStreams streams = new KafkaStreams(builder.build(), getProps());"".toUpperCase();
        final CountDownLatch latch = new CountDownLatch(1);

//        // attach shutdown handler to catch control-c
//        Runtime.getRuntime().addShutdownHook(new Thread("streams-wordcount-shutdown-hook") {
//            @Override
//            public void run() {
//                streams.close();
//                latch.countDown();
//            }
//        });

        try {
            streams.start();
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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