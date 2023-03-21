package fr.varex13.mqtt.sampleapp;

import fr.varex13.mqtt.library.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);

    private final Greeter greeter;

    public AppService(final Greeter greeter) {
        this.greeter = greeter;
    }

    public void getZaza() {
        final String greet = greeter.greet();
        LOGGER.info("- {}", greet);
    }

}
