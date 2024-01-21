package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringRestClientExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestClientExamplesApplication.class, args);
	}
}
