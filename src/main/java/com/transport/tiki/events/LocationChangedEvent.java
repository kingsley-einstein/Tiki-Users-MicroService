package com.transport.tiki.events;

import com.transport.tiki.models.Location;

//import com.transport.tiki.models.Ride;

public class LocationChangedEvent implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Location location;

    public LocationChangedEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}