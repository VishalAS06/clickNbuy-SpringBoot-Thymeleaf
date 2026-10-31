package com.example.clickNbuy.service;
import jakarta.servlet.http.HttpSession;

import java.security.Principal;

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

	String addToCart(Long id, HttpSession session, Principal principal);

	String viewCart(HttpSession session, Principal principal, ModelMap map);

	String increase(HttpSession session, Long id, ModelMap map);

	String decrease(HttpSession session, Long id, ModelMap map);
	

	

}
