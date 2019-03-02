package com.transport.tiki.dispatchers;

import com.transport.tiki.events.RideRequestedEvent;
import com.transport.tiki.events.RideTerminatedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {

    private static final Logger logger = LoggerFactory.getLogger(EventDispatcher.class);

    private RabbitTemplate template;
    private String exchanger;
    private String requestRoutingKey;
    private String terminationRoutingKey;

    @Autowired
    public EventDispatcher(
        RabbitTemplate template, 
        @Value("${amqp.exchanger}") String exchanger, 
        @Value("${amqp.eventRouting.request}") String requestRoutingKey,
        @Value("${amqp.eventRouting.terminate}") String terminationRoutingKey
    ) {
        this.template = template;
        this.exchanger = exchanger;
        this.requestRoutingKey = requestRoutingKey;
        this.terminationRoutingKey = terminationRoutingKey;
    }

    public void sendRideRequestedEvent(RideRequestedEvent event) {
        logger.info("Sending ride request event > ...");
        template.convertAndSend(exchanger, requestRoutingKey, event);
    }

    public void sendRideTerminatedEvent(RideTerminatedEvent event) {
        logger.info("Sending ride terminated event > ...");
        template.convertAndSend(exchanger, terminationRoutingKey, event);
    }
}