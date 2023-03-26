package fr.varex13.mqtt.sampleapp.temperature;

import jakarta.annotation.PostConstruct;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.messaging.MessageHeaders;

public abstract class AbstractInBoundConfiguration<T> {
    protected final IntegrationFlowContext flowContext;
    private String topic;
    private Class<T> topicType;

    protected AbstractInBoundConfiguration(IntegrationFlowContext flowContext, final String humidite, final Class<T> humiditeDtoClass) {
        this.flowContext = flowContext;
        topic = humidite;
        topicType = humiditeDtoClass;
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

    protected abstract Object processNominal(T dto, MessageHeaders headers) ;
}
