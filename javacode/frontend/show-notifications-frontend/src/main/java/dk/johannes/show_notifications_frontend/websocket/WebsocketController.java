package dk.johannes.show_notifications_frontend.websocket;

import dk.johannes.show_notifications_frontend.core.EventStringData;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebsocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public EventStringData greeting(HelloMessage message) throws Exception {

        return new EventStringData("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
