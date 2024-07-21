package dk.johannes.show_notifications_frontend.springeventing;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MySomethingHappenedEvent extends ApplicationEvent {

    private final String message;

    public MySomethingHappenedEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}
