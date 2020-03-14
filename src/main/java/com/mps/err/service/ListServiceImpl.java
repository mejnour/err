package com.mps.err.service;

import java.util.Optional;

import com.mps.err.business.model.User;
import com.mps.err.infra.ListService;
import com.mps.err.infra.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ListServiceImpl implements ListService {

    @Autowired
    private UserRepository userRepo;
    
    public ResponseEntity<?> listUserByLogin(String userName) {
        Optional<User> optionalUser = userRepo.findByLogin(userName); 
        if(optionalUser.isPresent())
            return ResponseEntity.ok(optionalUser.get());          
        else
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);         // NoSuchElementException handler
    }
}