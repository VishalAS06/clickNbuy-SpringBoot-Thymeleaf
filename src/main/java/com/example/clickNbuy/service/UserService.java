package com.example.clickNbuy.service;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.example.clickNbuy.dto.UserDto;

import jakarta.validation.Valid;

public interface UserService {

	String registerUser(@Valid UserDto userDto, BindingResult result, ModelMap map);

	String confirmOtp(Long id, int otp, ModelMap map);

	

}
