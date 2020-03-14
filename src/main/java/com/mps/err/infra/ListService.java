package com.mps.err.infra;

import org.springframework.http.ResponseEntity;

public interface ListService {
    ResponseEntity<?> listUserByLogin(String userName);

}