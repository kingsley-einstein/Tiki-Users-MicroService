package com.transport.tiki.resolvers.entities;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.transport.tiki.models.Location;
import com.transport.tiki.models.User;

public class LocationResolver implements GraphQLResolver<Location> {

    public User getUser(Location location) {
        return location.getUser();
    }
}