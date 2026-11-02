package com.example.clickNbuy.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clickNbuy.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
