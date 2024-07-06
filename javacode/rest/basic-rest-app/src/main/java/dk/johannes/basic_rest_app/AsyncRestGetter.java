package dk.johannes.basic_rest_app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class AsyncRestGetter {

    @Async
    public void getHelloFromProducer(){
        String name = Thread.currentThread().getName();
        log.info("Hello From Thread: {}", name);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8085/getSomethingAsync", String.class);
        log.info("Response from producer for thread: {} - response: {}", name, forEntity.getStatusCode());
    }
}
