package com.transport.tiki.repositories;

import java.util.Optional;

import com.transport.tiki.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByToken(String token);
    User findByCard(String card);
    Optional<User> findByUsername(String username);
}