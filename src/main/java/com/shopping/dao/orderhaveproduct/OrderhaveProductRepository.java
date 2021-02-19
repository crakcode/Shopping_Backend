package com.shopping.dao.orderhaveproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.entity.Order;
import com.shopping.entity.OrderhaveProduct;
import com.shopping.entity.Product;
import com.shopping.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderhaveProductRepository extends JpaRepository<OrderhaveProduct, Long> {


}
