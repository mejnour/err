package com.mps.err.service;

import com.mps.err.infra.ListAllService;
import com.mps.err.infra.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ListAllSerirviceImpl implements ListAllService {

    @Autowired
	private UserRepository userRepo;
	
	@Override
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(userRepo.findAll());
    }


}