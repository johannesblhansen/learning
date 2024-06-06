package dk.johannes.basic_rest_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

    @Value("${my.env.thing}")
    private String myEnvThingString;

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        System.out.println(myEnvThingString);
        return ResponseEntity.ok("Hello from in here");
    }
}
