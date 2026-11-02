
package com.example.clickNbuy.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String loadHome(HttpSession session, ModelMap map,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "12") int size,
			@RequestParam(defaultValue = "name") String sort,
			@RequestParam(defaultValue = "asc") String direction) {
		manageMessage(session, map);
		Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
		Sort sortObj;
		
		// Handle special sorting cases
		switch (sort.toLowerCase()) {
			case "price":
				sortObj = Sort.by(sortDirection, "price");
				break;
			case "category":
				sortObj = Sort.by(sortDirection, "category");
				break;
			case "name":
			default:
				sortObj = Sort.by(sortDirection, "name");
				break;
		}
		
		PageRequest pageable = PageRequest.of(page, size, sortObj);
		Page<Product> productPage = productRepository.findAll(pageable);
		
		map.put("products", productPage.getContent());
		map.put("currentPage", page);
		map.put("totalPages", productPage.getTotalPages());
		map.put("totalItems", productPage.getTotalElements());
		map.put("sort", sort);
		map.put("direction", direction);
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
