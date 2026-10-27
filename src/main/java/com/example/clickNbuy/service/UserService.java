package com.example.clickNbuy.service;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.example.clickNbuy.dto.PasswordDto;
import com.example.clickNbuy.dto.UserDto;

import jakarta.validation.Valid;

public interface UserService {

	String registerUser(UserDto userDto, BindingResult result, HttpSession session);

	String confirmOtp(Long id, int otp, HttpSession session);

	String resendOtp(Long id, HttpSession session);

	String forgotPassword(String email, HttpSession session);

	String resetPassword(PasswordDto passwordDto, BindingResult result, HttpSession session, Long id,ModelMap map);
	

	

}
