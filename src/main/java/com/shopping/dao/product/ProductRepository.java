package com.shopping.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Product;
import com.shopping.entity.User;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
