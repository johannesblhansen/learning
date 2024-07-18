package dk.johannes.show_notifications_frontend.rest;

import dk.johannes.show_notifications_frontend.springeventing.MySomethingHappenedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/update")
    public String result(){

        publisher.publishEvent(new MySomethingHappenedEvent(this, "This Is An Event Message"));

        return "Hello From Update Controller";
    }
}
