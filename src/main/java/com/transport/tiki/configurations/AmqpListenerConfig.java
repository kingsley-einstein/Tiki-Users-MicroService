package com.transport.tiki.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class AmqpListenerConfig implements RabbitListenerConfigurer {

    @Bean
    public TopicExchange exchange() {
        return null;
    }

    @Bean
    public Queue queue() {
        return null;
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return null;
    }

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        return null;
    }

    @Bean
    public DefaultMessageHandlerMethodFactory factory() {
        return null;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {

    }

}