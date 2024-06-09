package dk.johannes.producer_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @GetMapping("/getSomething")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hello from the producer");
    }
}
