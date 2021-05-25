package com.spring.service;

import java.util.List;

import com.spring.model.Category;

public interface ProductService {
	
	List<String> getCategories();
	
	Category getCategory(Integer id);

}
