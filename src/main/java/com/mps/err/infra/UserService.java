package com.mps.err.infra;

import com.mps.err.business.model.User;

import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> removeUser(String login);
    ResponseEntity<?> addUser(User user);
    
}