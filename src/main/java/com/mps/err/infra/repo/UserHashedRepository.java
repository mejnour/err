package com.mps.err.infra.repo;

import com.mps.err.business.model.UserHashedJwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHashedRepository extends JpaRepository<UserHashedJwt, Long> {

}