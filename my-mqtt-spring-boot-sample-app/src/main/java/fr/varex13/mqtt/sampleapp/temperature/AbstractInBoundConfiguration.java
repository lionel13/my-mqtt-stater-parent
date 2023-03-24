package fr.varex13.mqtt.sampleapp.temperature;

import fr.varex13.mqtt.sampleapp.humidity.HumiditeDto;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Transformers;
import org.springframework.messaging.MessageHeaders;

public abstract class AbstractInBoundConfiguration<T> {


  protected IntegrationFlow inbound(final String topic, final Class<T> topicType) {
        return IntegrationFlow
                .from(topic)
                .transform(Transformers.fromJson(topicType))
                .handle(this::processNominal)
                .get();
    }
//
//    protected abstract String getTopic();
//    protected abstract Class<T> getDto();
    protected abstract Object processNominal(T dto, MessageHeaders headers) ;
}
