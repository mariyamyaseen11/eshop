package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Category;
import com.spring.repository.CategoryRepository;
import com.spring.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<String> getCategories() {
		
		List<Category> categories = categoryRepository.findAll();
		
		List<String> list = new ArrayList<>();
		
		for(Category cat : categories) {
			list.add(cat.getCategoryName());
			
		}
		
		return list;
	}

	@Override
	public Category getCategory(Integer id) {
		
		Category cat = categoryRepository.findById(id);
		
		return cat;
	}

}
