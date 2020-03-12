package com.mps.err.business.control;

import com.mps.err.business.model.User;
import com.mps.err.infra.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;

@RestController
@RequestMapping("/api/v1/err")
public class UserControl{

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody @NonNull User user){
        return userService.addUser(user);
    }

    @GetMapping("/")
    public ResponseEntity<?> listAll(){
        return userService.listAll();
    }

    @GetMapping("/listUser")
    public ResponseEntity<?> listUser(@RequestParam("user") @NonNull String User){
        return userService.listUser(User);
    }
    
    @DeleteMapping("/")
    public ResponseEntity<?> deleteUser(@RequestParam("user") @NonNull String User){
        return userService.removeUser(User);
    }

}