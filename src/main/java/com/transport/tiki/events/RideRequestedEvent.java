package com.transport.tiki.events;

import com.transport.tiki.models.Ride;

public class RideRequestedEvent implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;

    private Ride ride;

    public RideRequestedEvent(Ride ride) {
        this.ride = ride;
    }

    public Ride getRide() {
        return ride;
    }
}