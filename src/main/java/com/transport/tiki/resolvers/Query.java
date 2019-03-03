package com.transport.tiki.resolvers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.transport.tiki.exceptions.AnException;
import com.transport.tiki.models.Ride;
import com.transport.tiki.models.User;
import com.transport.tiki.repositories.RideRepository;
import com.transport.tiki.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Component;

public class Query implements GraphQLQueryResolver {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RideRepository rideRepository;

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    public User getByToken(String token) {
        return userRepository.findByToken(token)
            .orElseThrow(
                () -> new AnException(
                HttpServletResponse.SC_NOT_FOUND, 
                "User with that token not found"
                )
                );
    }

    public User getByCard(String card) {
        return userRepository.findByCard(card)
            .orElseThrow(
                () -> new AnException(
                HttpServletResponse.SC_NOT_FOUND, 
                "User with specified card number not found"
                )
                );
    }

    public List<Ride> getAllRidesByUser(Long id, Integer page) {
        PageRequest request = new PageRequest(page, 10);
        Page<Ride> rides = rideRepository.findByUser(
            userRepository.findOne(id), 
            request.next()
            );

        return rides.getContent();
    }

    public Ride getRide(Long id) {
        return rideRepository.findOne(id);
    }
}