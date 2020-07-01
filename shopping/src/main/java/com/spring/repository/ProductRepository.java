package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Category;
import com.spring.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

//	Product findByProductid(int productid);

//	void deleteByProductid(int productid);
	
	Product findById(Integer id);

	void deleteById(Integer id);
	
	List<Product> findAllByCategory(Category category);
}
