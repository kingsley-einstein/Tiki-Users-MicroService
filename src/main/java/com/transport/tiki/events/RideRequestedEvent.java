package com.transport.tiki.events;

//import com.transport.tiki.models.Ride;

public class RideRequestedEvent implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    // private Ride ride;

    private Long rideId;
    private String username;
    private Integer latitude;
    private Integer longitude;
    private String location;
    private String destination;

    public RideRequestedEvent(Long rideId, String username, Integer latitude, Integer longitude, String location,
            String destination) {
        this.rideId = rideId;
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.destination = destination;
    }

    public Long getRideId() {
        return rideId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDestination() {
        return destination;
    }
}