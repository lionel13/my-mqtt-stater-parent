package fr.varex13.mqtt.autoconfigure;

import fr.varex13.mqtt.library.Greeter;
import fr.varex13.mqtt.library.GreetingConfig;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static fr.varex13.mqtt.library.GreeterConfigParams.*;

@Configuration
@ConditionalOnClass(Greeter.class)
@EnableConfigurationProperties({GreeterProperties.class, MqttServerProperties.class})
public class GreeterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GreetingConfig greeterConfig(final GreeterProperties greeterProperties) {
        String userName = greeterProperties.getUserName() == null ? System.getProperty("user.name") : greeterProperties.getUserName();
        
        String morningMessage = greeterProperties.getMorningMessage() == null ? "Good Morning" : greeterProperties.getMorningMessage();
      
        String afternoonMessage = greeterProperties.getAfternoonMessage() == null ? "Good Afternoon" : greeterProperties.getAfternoonMessage();
        
        String eveningMessage = greeterProperties.getEveningMessage() == null ? "Good Evening" : greeterProperties.getEveningMessage();
        
        String nightMessage = greeterProperties.getNightMessage() == null ? "Good Night" : greeterProperties.getNightMessage();

        GreetingConfig greetingConfig = new GreetingConfig();
        greetingConfig.put(USER_NAME, userName);
        greetingConfig.put(MORNING_MESSAGE, morningMessage);
        greetingConfig.put(AFTERNOON_MESSAGE, afternoonMessage);
        greetingConfig.put(EVENING_MESSAGE, eveningMessage);
        greetingConfig.put(NIGHT_MESSAGE, nightMessage);
        return greetingConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreetingConfig greetingConfig) {
        return new Greeter(greetingConfig);
    }

    @Bean
    @ConditionalOnMissingBean
    MqttConnectionOptions options(final MqttServerProperties mqttServerProperties) {
        final MqttConnectionOptions options = new MqttConnectionOptions();
        options.setServerURIs(new String[]{mqttServerProperties.getUri()});
        return options;
    }

}
