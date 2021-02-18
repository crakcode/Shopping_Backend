package com.shopping.service.product;

import java.io.File;
import java.io.InputStream;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.dao.product.ProductRepository;
import com.shopping.entity.Product;

import io.jsonwebtoken.io.IOException;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/product")
public class ProductService{
	
//	@Autowired
//	private OrderRepository orderReps;
	
	@Autowired
	private ProductRepository productReps;
//	
//	public void saveProduct(Product productTO) {
//		productReps.save(productTO);
//	}
	

	@GetMapping(value="/s")
	public String hell() {
		return "helloworld";
	}
	@PostMapping(value="/save")
	public void saveProduct(@RequestBody Product product) {
		System.out.println(product.getDescription());
		productReps.save(product);
	}
	
	
//	/,파라미터  SalesInfoSaveRequestDto dto
	@PostMapping(value="/upload")
	public String saveSell(@RequestParam("files") MultipartFile files) { 
		try {
			String baseDir = "C:\\Users\\forcs\\Desktop\\spring\\spring_lecture_09_sourcecode\\Shopping_Backend\\src\\main\\resources\\image";
			String filePath = baseDir + "\\" + files.getOriginalFilename();
			System.out.println(filePath);	
			files.transferTo(new File(filePath));
			
//			Authentication user = SecurityContextHolder.getContext().getAuthentication(); 
//			String sellerID = user.getName(); 
//			dto.setUserID(sellerID); 
//			dto.setSellImgUrl(filePath);
//			salesInfoService.Save(dto); 
			return "sell"; 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "22"; 
	 }
//	@GetMapping(value = "/get/image",produces = MediaType.IMAGE_JPEG_VALUE)
//			public @ResponseBody byte[] getImageWithMediaType() throws IOException, java.io.IOException {
//			    InputStream in = getClass()
//			      .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
//			    return IOUtils.toByteArray(in);
//	}

}

