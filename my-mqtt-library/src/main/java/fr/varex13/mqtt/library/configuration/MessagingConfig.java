package fr.varex13.mqtt.library.configuration;

import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(value = "fr.varex13.mqttintegration.v5")
public class MessagingConfig {

    private final MqttServerProperties mqttServerProperties;

    public MessagingConfig(final MqttServerProperties mqttServerProperties) {
        this.mqttServerProperties = mqttServerProperties;
    }


    @Bean
    MqttConnectionOptions options() {
        final MqttConnectionOptions options = new MqttConnectionOptions();
        options.setServerURIs(new String[]{mqttServerProperties.getUri()});
        return options;
    }

}
