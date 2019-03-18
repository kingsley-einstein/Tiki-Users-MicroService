package com.transport.tiki.events;

//import com.transport.tiki.models.Location;

//import com.transport.tiki.models.Ride;

public class LocationChangedEvent implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private Integer latitude;
    private Integer longitude;

    public LocationChangedEvent(Long userId, Integer latitude, Integer longitude) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }
}