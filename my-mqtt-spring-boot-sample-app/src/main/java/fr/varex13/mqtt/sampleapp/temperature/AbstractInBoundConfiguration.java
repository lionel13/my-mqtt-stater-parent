package fr.varex13.mqtt.sampleapp.temperature;

import jakarta.annotation.PostConstruct;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.messaging.MessageHeaders;

public abstract class AbstractInBoundConfiguration<T> {
    protected final IntegrationFlowContext flowContext;
    private final String topic;
    private final Class<T> topicType;

    protected AbstractInBoundConfiguration(IntegrationFlowContext flowContext, final String topic, final Class<T> topicType) {
        this.flowContext = flowContext;
        this.topic = topic;
        this.topicType = topicType;
    }

    @PostConstruct
    public void init() {
        this.flowContext.registration(inbound(topic, topicType)).register();
    }

  protected IntegrationFlow inbound(final String topic, final Class<T> topicType) {
        return IntegrationFlow
                .from(topic)
                .transform(Transformers.fromJson(topicType))
                .handle(this::processNominal)
                .get();
    }

    protected abstract T processNominal(T dto, MessageHeaders headers) ;
}
