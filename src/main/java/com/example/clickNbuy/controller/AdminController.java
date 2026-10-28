package com.example.clickNbuy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.clickNbuy.dto.ProductDto;

import jakarta.validation.Valid;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/add-product")
	public String loadAddProduct(ProductDto productDto) {
		return "add-product.html";
	}

	@PostMapping("/add-product")
	public String addProduct(@Valid ProductDto productDto, BindingResult result) {
		if (productDto.getImage().isEmpty())
			result.rejectValue("image", "error.image", "* Image is Required");
		
		if (result.hasErrors())
			return "add-product.html";
		else
			return "redirect:https://www.youtube.com";
	}

}
