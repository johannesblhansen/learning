package dk.johannes.show_notifications_frontend.springeventing;

import dk.johannes.show_notifications_frontend.websocket.MessageToStompTopicSender;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyInternalEventListener {

    private final MessageToStompTopicSender messageToStompTopicSender;

    public MyInternalEventListener(MessageToStompTopicSender messageToStompTopicSender) {
        this.messageToStompTopicSender = messageToStompTopicSender;
    }

    @EventListener
    public void doSomethingWithEvent(MySomethingHappenedEvent mySomethingHappenedEvent){
        messageToStompTopicSender.sendGreeting();
    }
}
