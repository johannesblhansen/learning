package dk.johannes.show_notifications_frontend.websocket;

import dk.johannes.show_notifications_frontend.core.EventStringData;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageToStompTopicSender {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public MessageToStompTopicSender(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendGreeting() {
        simpMessagingTemplate.convertAndSend("/topic/greetings", new EventStringData("StompTopicSender created this"));
    }
}
