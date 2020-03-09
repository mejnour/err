package com.mps.err.infra;

import java.util.Optional;

import com.mps.err.business.control.UserRepository;
import com.mps.err.business.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl{

    @Autowired
    private UserRepository userRepo;

    public ResponseEntity<?> addUser(User user){
        Optional<User> optionalUser = userRepo.findById(user.getId());  // IllegalArgumentException handler
        if(optionalUser.isPresent())
            return ResponseEntity.ok(userRepo.save(user));       
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(userRepo.findAll());
    }
    
    public ResponseEntity<?> listUser(String userName) {
        Optional<User> optionalUser = userRepo.findByName(userName);    // NoSuchElementException handler
        if(optionalUser.isPresent())
            return ResponseEntity.ok(optionalUser.get());          
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    public ResponseEntity<?> removeUser(String userName) {
        Optional<User> optionalUser = userRepo.findByName(userName);    // IllegalArgumentException handler
        if(optionalUser.isPresent()){
            userRepo.delete(optionalUser.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}