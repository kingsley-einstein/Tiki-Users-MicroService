package com.transport.tiki;

import com.transport.tiki.dispatchers.EventDispatcher;
import com.transport.tiki.resolvers.Mutation;
import com.transport.tiki.resolvers.Query;
import com.transport.tiki.resolvers.entities.LocationResolver;
import com.transport.tiki.resolvers.entities.RideResolver;
import com.transport.tiki.resolvers.entities.UserResolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TikiUsersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TikiUsersApiApplication.class, args);
	}

	@Bean
	public Mutation mutationBean(EventDispatcher dispatcher) {
		return new Mutation(dispatcher);
	}

	@Bean
	public Query queryBean() {
		return new Query();
	}

	@Bean
	public LocationResolver locationResolverBean() {
		return new LocationResolver();
	}

	@Bean
	public RideResolver rideResolverBean() {
		return new RideResolver();
	}

	@Bean
	public UserResolver userResolverBean() {
		return new UserResolver();
	}

}
