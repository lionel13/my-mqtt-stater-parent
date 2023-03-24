package fr.varex13.mqtt.sampleapp;

import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.mqtt.inbound.Mqttv5PahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.MqttHeaders;

@Configuration
public class InboundConfiguration {

    @Bean
    MessageProducerSupport inbound(final MqttConnectionOptions mqttConnectionOptions) {
        return new Mqttv5PahoMessageDrivenChannelAdapter(mqttConnectionOptions, "consumer", "temperature", "humidite");
    }

    @Bean
    IntegrationFlow inboundFlows(final MessageProducerSupport inboundAdapter) {
        return IntegrationFlow
                .from(inboundAdapter)
                .route("headers['" + MqttHeaders.RECEIVED_TOPIC + "']")
                .get();
    }
}
