package com.biorecruit.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biorecruit.entity.Product;
import com.biorecruit.entity.User;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
