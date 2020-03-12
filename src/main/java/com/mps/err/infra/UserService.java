package com.mps.err.infra;

import com.mps.err.business.model.User;

import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<?> addUser(User user);
    public ResponseEntity<?> listAll();
    public ResponseEntity<?> listUser(String userName);
    public ResponseEntity<?> removeUser(String userName);
}