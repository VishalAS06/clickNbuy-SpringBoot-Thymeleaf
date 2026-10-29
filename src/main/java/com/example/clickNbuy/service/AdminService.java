package com.example.clickNbuy.service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import com.example.clickNbuy.dto.ProductDto;
import com.example.clickNbuy.entity.Product;
import jakarta.servlet.http.HttpSession;

public interface AdminService {
	
	String addProduct(ProductDto productDto, BindingResult result, HttpSession session);

	String deleteProduct(Long id, HttpSession session);

	String editProduct(Long id, ModelMap map);

	String updateProduct(Product product, MultipartFile image, HttpSession session);

}
