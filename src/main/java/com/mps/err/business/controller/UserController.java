package com.mps.err.business.controller;

import com.mps.err.business.model.User;
import com.mps.err.infra.ListAllService;
import com.mps.err.infra.ListService;
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
public class UserController{

    /**
     * TODO: Criar um singleton
     * TODO: Na camada business implemente, utilizando Template Method, a geração de mais um tipo de relatórios (por exemplo, PDF e HTML)  Os relatórios devem gerar estatísticas de acesso dos usuários no sistema. 
     */

    @Autowired
    private UserService userService;

    @Autowired
    private ListAllService listAllService;

    @Autowired
    private ListService listService;

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody @NonNull User user){
        return userService.addUser(user);
    }

    @GetMapping("/")
    public ResponseEntity<?> listAll(){
        return listAllService.listAll();
    }

    @GetMapping("/listUser")
    public ResponseEntity<?> listUser(@RequestParam("user") @NonNull String User){
        return listService.listUserByLogin(User);
    }
    
    @DeleteMapping("/")
    public ResponseEntity<?> deleteUser(@RequestParam("user") @NonNull String User){
        return userService.removeUser(User);
    }

}