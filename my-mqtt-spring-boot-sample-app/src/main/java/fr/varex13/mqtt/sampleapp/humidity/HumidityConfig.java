package fr.varex13.mqtt.sampleapp.humidity;

import fr.varex13.mqtt.sampleapp.temperature.AbstractInBoundConfiguration;
import fr.varex13.mqtt.sampleapp.temperature.TemperatureDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Transformers;
import org.springframework.messaging.MessageHeaders;

@Configuration
public class HumidityConfig extends AbstractInBoundConfiguration<HumiditeDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HumidityConfig.class);

    @Bean
    IntegrationFlow inboundHumidity() {
        return inbound("humidite",HumiditeDto.class );
    }

    @Override
    protected HumiditeDto processNominal(final HumiditeDto payload, final MessageHeaders headers) {
        LOGGER.info("new Message humidite ! {}", payload);
        headers.forEach((s, o) -> LOGGER.info("{} = {}", s, o));
        return null;
    }

}
