package com.transport.tiki.events;

//import com.transport.tiki.models.Ride;

public class RideTerminatedEvent implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long rideId;

    public RideTerminatedEvent(Long rideId) {
        this.rideId = rideId;
    }

    public Long getRideId() {
        return rideId;
    }
}