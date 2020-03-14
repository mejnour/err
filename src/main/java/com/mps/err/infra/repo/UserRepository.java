package com.mps.err.infra.repo;

import java.util.Optional;

import com.mps.err.business.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> removeUser(String login);
    ResponseEntity<?> addUser(User user);
	Optional<User> findByLogin(String userName);

}