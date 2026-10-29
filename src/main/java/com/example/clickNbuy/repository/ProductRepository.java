package com.example.clickNbuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clickNbuy.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {

	boolean existsByName(String name); 

}
