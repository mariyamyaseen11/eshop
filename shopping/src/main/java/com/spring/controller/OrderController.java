package com.spring.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.constants.WebConstants;
import com.spring.service.OrderService;
import com.spring.service.ProductService;


@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/order")
	public void categories(@RequestHeader(name = WebConstants.USER_AUTH_TOKEN) String AUTH_TOKEN) throws IOException {
		//List<Category> categories = categoryRepo.findAll();
		orderService.save(AUTH_TOKEN);
		
		//return new ResponseEntity<?>(categories, HttpStatus.ACCEPTED);
	}
}
