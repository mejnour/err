package com.mps.err.business.control;

import java.util.Optional;

import com.mps.err.business.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

}