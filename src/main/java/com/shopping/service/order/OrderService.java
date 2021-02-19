package com.shopping.service.order;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.dao.order.OrderRepository;
import com.shopping.dao.orderhaveproduct.OrderhaveProductRepository;
import com.shopping.dao.product.ProductRepository;
import com.shopping.dao.user.UserRepository;
import com.shopping.entity.Order;
import com.shopping.entity.OrderhaveProduct;
import com.shopping.entity.Product;
import com.shopping.entity.User;

import io.jsonwebtoken.io.IOException;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/order")
public class OrderService{
	
	@Autowired
	private OrderRepository orderReps;
	
	@Autowired
	private ProductRepository productReps;
	
	@Autowired
	private OrderhaveProductRepository ohpReps;
	
	@Autowired
	private UserRepository userReps;
	
	
//	
//	public void saveProduct(Product productTO) {
//		productReps.save(productTO);
//	}
	
	// Order 를 넣었을때 Order have product를 넘긴다.
	@GetMapping("/find")
	public List<OrderhaveProduct> getOrderhaveProduct() {
		return ohpReps.findAll();
	}
	
	// Order 를 저장한다. 즉 이상태는 결제 대기 상태로 처리된다. 
	// 구매하기 버튼을 눌렀을떄 진행되는 로직이다. 
	@PostMapping("/{pId}/{id}")
	public void saveOrder(@RequestBody Order order,@PathVariable Long pId,@PathVariable Long id) {
		OrderhaveProduct ohp=new OrderhaveProduct();
		Product product= productReps.findById(pId).get();
		User user=userReps.findById(id).get();
		order.setUser(user);
		ohp.setProduct(product);
		ohp.setOrder(order);
		ohp.setStatus("결제대기");
		ohpReps.save(ohp);
	}
	
	// 결제 대기 상태의 놓인 것중에서 결제를 완료했을때 처리하는 로직을 개발한다. 
	// 결제를 완료시 상태값이 바뀐다. 
	// 해당 Service 는 상태값을 바꾸는 것이기에 모든것에 재사용 가능 상태의 변화에 있어서는
	
	@PostMapping("/complete/{oId}")
	public void completOrder(@PathVariable Long oId) {
		System.out.println(oId);
		Order order=orderReps.findById(oId).get();
		Long ohpId=orderReps.findByUidForOhpid(oId);
		OrderhaveProduct ohp=ohpReps.findById(ohpId).get();
		int amount=ohp.getProduct().getAmount()-ohp.getOrder().getOrder_amount();
		if (amount<0) {
			ohp.setStatus("재고부족");
			ohpReps.save(ohp);
		}
		else {
			Product product=productReps.findById(ohp.getProduct().getpId()).get();
			product.setAmount(amount);
			ohp.setProduct(product);
			ohp.setStatus("결제완료");
			ohpReps.save(ohp);
		}
	}
	
	
	// 결제 취소시 해당 url을 호출해준다. 
	@PostMapping("/cancel/{oId}")
	public void cancelOrder(@PathVariable Long oId) {
		System.out.println(oId);
		Order order=orderReps.findById(oId).get();
		Long ohpId=orderReps.findByUidForOhpid(oId);
		OrderhaveProduct ohp=ohpReps.findById(ohpId).get();
		ohp.setStatus("주문취소");
		ohpReps.save(ohp);
	}

	
	
	// 아이디값으로 조회 
	// 상태값이 "결제완료" 사용자 "estein92" order조회
	@PostMapping("/find/{oId}/{id}")
	public OrderhaveProduct FindOrderByStatus(@PathVariable Long oId,@PathVariable Long id) {
		Long ohpId=orderReps.findByOrderUsingId(oId,id);
		OrderhaveProduct ohp=ohpReps.findById(ohpId).get();
		return ohp;
	}
	
	// 상태값으로 조회 사용자의 id값과 status 값을 넣으면 조회할수있다.
	// 
	
	@PostMapping("/find/status/{status}/{id}")
	public List<OrderhaveProduct> FindOrderByStatusAndId(@PathVariable String status,@PathVariable Long id) {
		List<Long> ohpIds=orderReps.findByOhpIdByStatusAndID(status,id);
		List<OrderhaveProduct> li=new ArrayList<OrderhaveProduct>();
		for (Long i : ohpIds) {
			System.out.println(ohpReps.findById(i).get().getStatus());
			li.add(ohpReps.findById(i).get());
		}
		
		return li;
	}
	
	
	

}

