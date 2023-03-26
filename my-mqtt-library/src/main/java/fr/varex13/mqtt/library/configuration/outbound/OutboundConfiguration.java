package fr.varex13.mqtt.library.configuration.outbound;

import org.eclipse.paho.mqttv5.client.IMqttAsyncClient;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.mqtt.outbound.AbstractMqttMessageHandler;
import org.springframework.integration.mqtt.outbound.Mqttv5PahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class OutboundConfiguration {

    @Bean
    MessageHandler outbound(final MqttConnectionOptions options) {
        AbstractMqttMessageHandler<IMqttAsyncClient, MqttConnectionOptions> handler = new Mqttv5PahoMessageHandler(options, "producer");
        handler.setDefaultTopic("test"); //TODO a remplacer
        return handler;
    }

    @Bean
    IntegrationFlow outboundFlow(
            final MessageChannel out,
            final MessageHandler outbound) {
        return IntegrationFlow
                .from(out)
                .transform(Transformers.toJson())
                .handle(outbound)
                .get();
    }

    @Bean
    MessageChannel out() {
        return MessageChannels.direct().get();
    }

}
