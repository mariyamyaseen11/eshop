package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Orders;


@Repository
//@Transactional
public interface OrdersRepository extends JpaRepository<Orders, Long>{
	//void save(Orders order);
}
