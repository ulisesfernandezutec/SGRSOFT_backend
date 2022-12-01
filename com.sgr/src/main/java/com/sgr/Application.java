package com.sgr;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	@Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> log.warn("Perfil activo " + environment.getProperty("spring.profiles.active"));

    }

}
