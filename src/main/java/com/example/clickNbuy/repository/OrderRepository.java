package com.example.clickNbuy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clickNbuy.entity.Order;
import com.example.clickNbuy.entity.User;
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    Order findByRazorpayOrderId(String razorpayOrderId);

}
