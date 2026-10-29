
package com.example.clickNbuy.controller;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.clickNbuy.dto.PasswordDto;
import com.example.clickNbuy.dto.UserDto;
import com.example.clickNbuy.entity.Product;
import com.example.clickNbuy.repository.ProductRepository;

import org.springframework.ui.ModelMap;
@Controller
public class ViewController {
	
	@Autowired
	ProductRepository productRepository;

    @GetMapping("/")
    public String loadHome(HttpSession session, ModelMap map) {
		manageMessage(session, map);
		List<Product> products = productRepository.findAll();
		if (!products.isEmpty())
			map.put("products", products);
        return "home";
    }
 

	@GetMapping("/login")
	public String loadLogin(HttpSession session, ModelMap map) {
		manageMessage(session, map);
        return "login";
    }

    @GetMapping("/register")
    public String loadRegister(UserDto userDto) {
        return "register";
    }
    
    @GetMapping("/otp")
	public String loadOtop(HttpSession session, ModelMap map) {
		if (session.getAttribute("id") != null) {
			map.put("id", session.getAttribute("id"));			
		}
		manageMessage(session, map);
		return "otp.html";
	}

	@GetMapping("/forgot-password")
	public String loadForgotPassword(HttpSession session, ModelMap map) {
		manageMessage(session, map);
		return "forgot-password.html";
	}

	@GetMapping("/reset-password")
	public String loadResetPassword(PasswordDto passwordDto, HttpSession session, ModelMap map) {
		if (session.getAttribute("id") != null) {
			map.put("id", session.getAttribute("id"));			
		}
		manageMessage(session, map);
		return "reset-password.html";
	}
    
	public void manageMessage(HttpSession session, ModelMap map) {
		if (session.getAttribute("success") != null) {
			map.put("success", session.getAttribute("success"));
			session.removeAttribute("success");
		}
		if (session.getAttribute("error") != null) {
			map.put("error", session.getAttribute("error"));
			session.removeAttribute("error");
		}
	}
    
   
}
