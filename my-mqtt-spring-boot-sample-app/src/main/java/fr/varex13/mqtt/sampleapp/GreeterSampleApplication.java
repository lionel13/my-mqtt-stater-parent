package fr.varex13.mqtt.sampleapp;

import fr.varex13.mqtt.library.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GreeterSampleApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreeterSampleApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(GreeterSampleApplication.class, args);
    }

    @Bean
    AppService appService(final Greeter greeter) {
        final String greet = greeter.greet();
        LOGGER.info("- {}", greet);
        return new AppService(greeter);
    }
}
