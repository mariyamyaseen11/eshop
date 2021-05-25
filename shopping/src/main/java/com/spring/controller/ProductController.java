package com.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.constants.WebConstants;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.repository.CategoryRepository;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;

@CrossOrigin(origins = WebConstants.ALLOWED_URL)
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductService productService;
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/categories")
//	public ResponseEntity<List<Category>> categories(@RequestHeader(name = WebConstants.USER_AUTH_TOKEN) String AUTH_TOKEN) throws IOException {
//		List<Category> categories = categoryRepo.findAll();
//		return new ResponseEntity<List<Category>>(categories, HttpStatus.ACCEPTED);
//	}
	
	
	@GetMapping("/category")
	public ResponseEntity<Category> getCategoryById(@RequestParam Integer id){
		Category cat = productService.getCategory(id);
		return new ResponseEntity<Category>(cat, HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<String>> categories() {
		
		List<String> categories = productService.getCategories();
		return new ResponseEntity<List<String>>(categories, HttpStatus.OK);
		
	}
	
	@GetMapping("/product")
	public ResponseEntity<Product> getProduct(@RequestParam Integer id) {
		Product product = productRepo.findById(id);
		return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProductsByCategory(@RequestHeader(name = WebConstants.USER_AUTH_TOKEN) String AUTH_TOKEN,
			@RequestParam String categoryName) {
		Category category = categoryRepo.findByCategoryName(categoryName);
		List<Product> productList = productRepo.findAllByCategory(category);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		
		List<Product> list = productRepo.findAll();
		
		return new ResponseEntity<List<Product>>(list, HttpStatus.ACCEPTED);
		
	}
	
	
	
}
