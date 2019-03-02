package com.transport.tiki.repositories;

import com.transport.tiki.models.Location;
import com.transport.tiki.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByUser(User user);
}