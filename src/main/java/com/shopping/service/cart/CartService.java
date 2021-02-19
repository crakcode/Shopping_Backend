package com.shopping.service.cart;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.dao.cart.CartRepository;
import com.shopping.dao.order.OrderRepository;
import com.shopping.dao.orderhaveproduct.OrderhaveProductRepository;
import com.shopping.dao.product.ProductRepository;
import com.shopping.entity.Cart;
import com.shopping.entity.Order;
import com.shopping.entity.Product;

import io.jsonwebtoken.io.IOException;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/cart")
public class CartService{
	
	@Autowired
	private OrderRepository orderReps;
	
	@Autowired
	private ProductRepository productReps;
	
	@Autowired
	private OrderhaveProductRepository ohpReps;
	
	@Autowired
	private CartRepository cartReps;
	
	@PostMapping("/{amount}/{pId}/{oId}")
	public Cart saveCart(@PathVariable int amount,@PathVariable Long pId,@PathVariable Long oId) {
		Optional<Product> product=productReps.findById(pId);
		Optional<Order> order=orderReps.findById(oId);
		Cart cart=new Cart();
		cart.setAmount(amount);
		cart.setProduct(product.get());
		cart.setOrder(order.get());
		cartReps.save(cart);
		return cart;
	}
	
	@DeleteMapping("/{cId}")
	public void deleteCart(@PathVariable Long cId) {
		Cart cart=cartReps.findById(cId).get();
		cartReps.delete(cart);
	}

}

