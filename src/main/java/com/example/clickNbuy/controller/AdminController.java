package com.example.clickNbuy.controller;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.clickNbuy.dto.ProductDto;
import com.example.clickNbuy.entity.Product;
import com.example.clickNbuy.service.AdminService;
import org.springframework.ui.ModelMap;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService; 
	
	@GetMapping("/add-product")
	public String loadAddProduct(ProductDto productDto) {
		return "add-product.html";
	}

	@PostMapping("/add-product")
	public String addProduct(@Valid ProductDto productDto, BindingResult result, HttpSession session) {
		return adminService.addProduct(productDto, result, session);
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id, HttpSession session) {
		return adminService.deleteProduct(id, session);
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Long id, ModelMap map) {
		return adminService.editProduct(id, map);
	}

	@PostMapping("/update-product")
	public String updateProduct(Product product,@RequestParam MultipartFile image ,HttpSession session) {
		return adminService.updateProduct(product, image, session);
	}

}
