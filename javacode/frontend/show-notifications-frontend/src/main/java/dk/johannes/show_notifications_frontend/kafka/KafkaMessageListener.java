package dk.johannes.show_notifications_frontend.kafka;

import dk.johannes.show_notifications_frontend.springeventing.MySomethingHappenedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMessageListener {

    @Autowired
    private ApplicationEventPublisher publisher;

    @KafkaListener(topics = "topicNumber2")
    public void listenForMessage(String message) {
        log.info("Received Message in group foo: {}", message);
        publisher.publishEvent(new MySomethingHappenedEvent(this, message));
    }
}
