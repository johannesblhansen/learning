package dk.johannes.basic_rest_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BasicRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicRestAppApplication.class, args);
	}

}
