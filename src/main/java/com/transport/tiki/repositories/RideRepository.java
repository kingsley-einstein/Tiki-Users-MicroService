package com.transport.tiki.repositories;

import com.transport.tiki.models.Ride;
import com.transport.tiki.models.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    Page<Ride> findByUser(User user, Pageable pageable);
}