package com.example.clickNbuy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clickNbuy.entity.CartItem;
import com.example.clickNbuy.entity.User;
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	List<CartItem> findByUser(User user);

}
