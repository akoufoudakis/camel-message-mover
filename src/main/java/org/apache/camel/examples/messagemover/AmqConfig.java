package org.apache.camel.examples.messagemover;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class AmqConfig {
    @Value("${url}")
    private String url;

    @Value("${spring.artemis.user}")
    private String user;

    @Value("${spring.artemis.password}")
    private String password;

    @Bean("connectionFactory")
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(this.url);
        cf.setPassword(password);
        cf.setUser(user);

        return cf;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

