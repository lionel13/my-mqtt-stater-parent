package fr.varex13.mqtt.sampleapp.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.messaging.MessageHeaders;

@Configuration
public class TemperatureConfig extends AbstractInBoundConfiguration<TemperatureDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureConfig.class);

    public TemperatureConfig(IntegrationFlowContext flowContext) {
        super(flowContext, "temperature", TemperatureDTO.class);
    }

    public TemperatureDTO processNominal(final TemperatureDTO temperatureDTO, final MessageHeaders headers) {
        LOGGER.info("new Message temperature ! {}", temperatureDTO);
        headers.forEach((s, o) -> LOGGER.info("{} = {}", s, o));
        return null;
    }
}
