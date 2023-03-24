package fr.varex13.mqtt.sampleapp.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Transformers;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import static org.springframework.integration.handler.LoggingHandler.Level.INFO;

@Configuration
public class TemperatureConfig {

    public static final String LOGGER_NAME = "temperature-logger";

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureConfig.class);

//    private final TemperatureService temperatureService;
//
//    public TemperatureConfig(final TemperatureService temperatureService) {
//        this.temperatureService = temperatureService;
//    }


    @Bean
    IntegrationFlow inboundTemperature() {
        return IntegrationFlow
                .from("temperature")
                .log(INFO, "TEST_LOGGER", TemperatureConfig::logMessage)
                .transform(Transformers.fromJson(TemperatureDTO.class))
                .handle(this::processNominal)
                .get();
    }

    private static String logMessage(final Message<Object> message) {
        return String.valueOf(message.getPayload()) + message.getHeaders();
    }

    private Object processNominal(final TemperatureDTO temperatureDTO, final MessageHeaders headers) {
        LOGGER.info("new Message temperature ! {}", temperatureDTO);
        headers.forEach((s, o) -> LOGGER.info("{} = {}", s, o));
//        temperatureService.hendleCreation(toTemperature(temperatureDTO));
        return null;
    }
}
