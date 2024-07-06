package dk.johannes.producer_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProducerController {

    private int count;

    @GetMapping("/getSomething")
    public ResponseEntity<String> getHello() throws InterruptedException {
        return ResponseEntity.ok("Hello from the producer");
    }

    @GetMapping("/getSomethingAsync")
    public ResponseEntity<String> getHelloAsync() throws InterruptedException {
        count++;
        log.info("Starting to sleep with count: {}", count);
        Thread.sleep(3000);
        return ResponseEntity.ok("Hello from the producer with count: " + count);
    }
}
