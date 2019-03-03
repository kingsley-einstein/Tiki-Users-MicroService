package com.transport.tiki.resolvers;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.transport.tiki.dispatchers.EventDispatcher;
import com.transport.tiki.events.LocationChangedEvent;
import com.transport.tiki.events.RideDestinationChangedEvent;
import com.transport.tiki.events.RideRequestedEvent;
import com.transport.tiki.events.RideTerminatedEvent;
import com.transport.tiki.exceptions.AnException;
import com.transport.tiki.models.Location;
import com.transport.tiki.models.Ride;
import com.transport.tiki.models.User;
import com.transport.tiki.repositories.LocationRepository;
import com.transport.tiki.repositories.RideRepository;
import com.transport.tiki.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;

public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RideRepository rideRepository;
    
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private EventDispatcher dispatcher;

    public User newUser(
        String username, 
        String phone, 
        String email, 
        String password, 
        String card, 
        String cvv
    ) {
        User user = new User(
            username, 
            phone, 
            email, 
            encoder.encode(password), 
            BCrypt.hashpw(UUID.randomUUID().toString(), BCrypt.gensalt()), 
            card, 
            cvv
        );

        return userRepository.save(user);
    }

    public User update(Long id, String phone, String email, String card, String cvv) {
        User user = userRepository.findOne(id);
        user.setPhone(phone);
        user.setEmail(email);
        user.setCard(card);
        user.setCVV(cvv);

        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new AnException(
                HttpServletResponse.SC_NOT_FOUND, 
                "User not found"
            )
            );
        
        if (encoder.matches(password, user.getPassword()))
            return user;
        else throw new AnException(
            HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
            "Incorrect password"
        );
    }

    public Ride request(String location, String destination, Long id) {
        Ride ride = new Ride(location, destination, userRepository.findOne(id), false);
        Ride savedRide = rideRepository.save(ride);

        dispatcher.sendRideRequestedEvent(
            new RideRequestedEvent(savedRide)
            );

        return savedRide;
    }

    public boolean fulfill(Long id) {
        Ride ride = rideRepository.findOne(id);

        ride.setFulfilled();
        rideRepository.save(ride);

        return true;
    }

    public boolean delete(Long id) {
        rideRepository.delete(id);

        return true;
    }

    public boolean terminate(Long id) {
        Ride ride = rideRepository.findOne(id);

        rideRepository.delete(ride);

        
        dispatcher.sendRideTerminatedEvent(
            new RideTerminatedEvent(ride)
            );

        return true;
    }

    public boolean change(Long id, String destination) {
        Ride ride = rideRepository.findOne(id);
        ride.setDestination(destination);

        Ride changedRide = rideRepository.save(ride);

        dispatcher.sendRideDestinationChangedEvent(
            new RideDestinationChangedEvent(changedRide)
            );
        
        return true;
    }

    public Location newLocation(
        Integer latitude, 
        Integer longitude, 
        String place, 
        Long id
        ) {
        Location location = locationRepository.findByUser(userRepository.findOne(id));

        if (location != null) {
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            location.setPlace(place);

            Location l = locationRepository.save(location);
            
            dispatcher.sendLocationChangedEvent(
                new LocationChangedEvent(l)
                );

            return l;
        }
        else {
            location = new Location(latitude, longitude, place, userRepository.findOne(id));

            return locationRepository.save(location);
        }
    }
}