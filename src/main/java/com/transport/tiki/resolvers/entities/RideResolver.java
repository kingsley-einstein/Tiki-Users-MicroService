package com.transport.tiki.resolvers.entities;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.transport.tiki.models.Ride;
import com.transport.tiki.models.User;

//import org.springframework.stereotype.Component;

public class RideResolver implements GraphQLResolver<Ride> {

    public User getUser(Ride ride) {
        return ride.getUser();
    }
}