package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long>  {
	
	List<Category> findAll();
	Category findById(Integer id);
	
	Category findByCategoryName(String name);

}
