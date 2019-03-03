package com.transport.tiki.resolvers.entities;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.transport.tiki.models.Location;
import com.transport.tiki.models.Ride;
import com.transport.tiki.models.User;

//import org.springframework.stereotype.Component;

public class UserResolver implements GraphQLResolver<User> {

    public List<Ride> getRequestedRides(User user) {
        return user.getRequestedRides();
    }

    public Location getLocation(User user) {
        return user.getLocation();
    }
}