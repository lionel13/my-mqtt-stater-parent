package fr.varex13.mqtt.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mqtt.server")
public class MqttServerProperties {

    private final String uri;

    public MqttServerProperties(final String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
