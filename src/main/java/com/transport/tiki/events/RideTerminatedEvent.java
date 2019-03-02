package com.transport.tiki.events;

import com.transport.tiki.models.Ride;

public class RideTerminatedEvent implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;

    private Ride ride;

    public RideTerminatedEvent(Ride ride) {
        this.ride = ride;
    }

    public Ride getRide() {
        return ride;
    }
}