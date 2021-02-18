package com.shopping.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Order;
import com.shopping.entity.Product;
import com.shopping.entity.User;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
