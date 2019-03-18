package com.transport.tiki.events;

//import com.transport.tiki.models.Ride;

public class RideDestinationChangedEvent implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long rideId;
    private String newDestination;

    public RideDestinationChangedEvent(Long rideId, String newDestination) {
        this.rideId = rideId;
    }

    public Long getRideId() {
        return rideId;
    }

    public String getNewDestination() {
        return newDestination;
    }
}