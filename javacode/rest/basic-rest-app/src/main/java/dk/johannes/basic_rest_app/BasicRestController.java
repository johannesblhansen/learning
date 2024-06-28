package dk.johannes.basic_rest_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BasicRestController {

    @Value("${my.env.thing}")
    private String myEnvThingString;

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        System.out.println(myEnvThingString);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://my-producer-container:8085/getSomething", String.class);

        String body = forEntity.getBody();

        return ResponseEntity.ok("Hello from in here and response from producer is: " + body);
    }
}
