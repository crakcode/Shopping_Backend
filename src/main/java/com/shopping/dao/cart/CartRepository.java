package com.shopping.dao.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Cart;
import com.shopping.entity.Order;
import com.shopping.entity.Product;
import com.shopping.entity.User;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
