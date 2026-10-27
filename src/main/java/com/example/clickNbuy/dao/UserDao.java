package com.example.clickNbuy.dao;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.clickNbuy.entity.User;
import com.example.clickNbuy.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;

	public boolean emailExists(String email) {
		return userRepository.existsByEmail(email);
	}

	public boolean mobileExists(Long mobile) {
		return userRepository.existsByMobile(mobile);
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow();
	}
	
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	

}
