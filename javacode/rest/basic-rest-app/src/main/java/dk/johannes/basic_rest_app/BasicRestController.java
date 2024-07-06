package dk.johannes.basic_rest_app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class BasicRestController {

    //Used for testing variables from docker
    @Value("${my.env.thing}")
    private String myEnvThingString;

    private final AsyncRestGetter asyncRestGetter;

    public BasicRestController(AsyncRestGetter asyncRestGetter) {
        this.asyncRestGetter = asyncRestGetter;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        System.out.println(myEnvThingString);
        RestTemplate restTemplate = new RestTemplate();
        //The my-producer-container is the url to be used inside a docker container, not used when starting directly on the machine
//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://my-producer-container:8085/getSomething", String.class); //Todo make property
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8085/getSomething", String.class);

        String body = forEntity.getBody();

        return ResponseEntity.ok("Hello from in here and response from producer is: " + body);
    }

    @GetMapping("/helloAsync")
    public ResponseEntity<String> getHelloAsync(){
        for (int i = 0; i < 100; i++) {
            log.info("Starting thread: {}", i);
            asyncRestGetter.getHelloFromProducer();
        }
        String body = "All threads started";
        return ResponseEntity.ok("Hello from in here and response from producer is: " + body);
    }


}
