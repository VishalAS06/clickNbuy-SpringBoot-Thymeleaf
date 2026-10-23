package com.example.clickNbuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clickNbuy.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	boolean existsByMobile(Long mobile);

}
