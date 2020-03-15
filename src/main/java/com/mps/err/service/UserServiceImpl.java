package com.mps.err.service;

import java.util.Optional;

import com.mps.err.business.model.User;
import com.mps.err.business.model.UserHashedJwt;
import com.mps.err.infra.UserService;
import com.mps.err.infra.repo.UserHashedRepository;
import com.mps.err.infra.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;    
    
    @Autowired
    private UserHashedRepository userHashedRepo;

    public ResponseEntity<?> addUser(User user){
        try {
            Optional<User> optionalUser = userRepo.findById(user.getId()); 
            if(!optionalUser.isPresent())
                return ResponseEntity.ok(userRepo.save(user));       
            else
                return new ResponseEntity<>("the user already exists.", HttpStatus.CONFLICT);  // IllegalArgumentException handler
        }catch(NullPointerException e){
            return new ResponseEntity<>("login can't be null.", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> addUserHashed(UserHashedJwt user){
        try {
            Optional<User> optionalUser = userRepo.findById(user.getId()); 
            if(!optionalUser.isPresent())
                return ResponseEntity.ok(userHashedRepo.save(user));       
            else
                return new ResponseEntity<>("the user already exists.", HttpStatus.CONFLICT);  // IllegalArgumentException handler
        }catch(NullPointerException e){
            return new ResponseEntity<>("login can't be null.", HttpStatus.BAD_REQUEST);
        }
    }
    
    public ResponseEntity<?> removeUser(String userName) {
        Optional<User> optionalUser = userRepo.findByLogin(userName);                          // IllegalArgumentException handler
        if(optionalUser.isPresent()){
            userRepo.delete(optionalUser.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
    }
}