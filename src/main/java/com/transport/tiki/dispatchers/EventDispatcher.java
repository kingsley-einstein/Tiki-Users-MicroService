package com.transport.tiki.dispatchers;

import com.transport.tiki.events.LocationChangedEvent;
import com.transport.tiki.events.RideDestinationChangedEvent;
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
    private String changeRoutingKey;
    private String locationChangeRoutingKey;

    @Autowired
    public EventDispatcher(RabbitTemplate template, @Value("${amqp.exchanger}") String exchanger,
            String requestRoutingKey, String terminationRoutingKey, String changeRoutingKey,
            String locationChangeRoutingKey) {
        this.template = template;
        this.exchanger = exchanger;
        this.requestRoutingKey = requestRoutingKey;
        this.terminationRoutingKey = terminationRoutingKey;
        this.changeRoutingKey = changeRoutingKey;
        this.locationChangeRoutingKey = locationChangeRoutingKey;
    }

    public void sendRideRequestedEvent(RideRequestedEvent event) {
        logger.info("Sending ride request event > ...");
        template.convertAndSend(exchanger, requestRoutingKey, event);
    }

    public void sendRideTerminatedEvent(RideTerminatedEvent event) {
        logger.info("Sending ride terminated event > ...");
        template.convertAndSend(exchanger, terminationRoutingKey, event);
    }

    public void sendRideDestinationChangedEvent(RideDestinationChangedEvent event) {
        logger.info("Sending ride destination change event > ...");
        template.convertAndSend(exchanger, changeRoutingKey, event);
    }

    public void sendLocationChangedEvent(LocationChangedEvent event) {
        logger.info("Sending location changed event > ...");
        template.convertAndSend(exchanger, locationChangeRoutingKey, event);
    }
}