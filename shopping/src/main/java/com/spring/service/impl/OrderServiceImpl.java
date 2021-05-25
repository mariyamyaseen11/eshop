package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Bufcart;
import com.spring.model.OrderDetails;
import com.spring.model.Orders;
import com.spring.model.User;
import com.spring.repository.CartRepository;
import com.spring.repository.OrdersRepository;
import com.spring.service.OrderService;
import com.spring.util.jwtUtil;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired 
	private jwtUtil util;
	
	@Autowired 
	private CartRepository cartRepo;
	
	@Autowired 
	private OrdersRepository orderRepo;
	

	/*@Override
	public void save(String token) {
		User user = util.checkToken(token);
		Bufcart cart = cartRepo.findByEmail(user.getEmail()).get(0);
		
		Orders order = new Orders();
		order.setUserId(user.getId());
		
		List<OrderDetails> orderDetailList = new ArrayList<>();
		for(CartDetails cartDetail : cart.getCartDetails()) {
			OrderDetails orderDetail = new OrderDetails();
			orderDetail.setProductId(cartDetail.getProductId());
			orderDetail.setPrice(100.0);
			orderDetail.setQuantity(cartDetail.getQuantity());
			orderDetailList.add(orderDetail);
			
		}*/
	
	
	@Override
	public void save(String token) {
		User user = util.checkToken(token);
		List<Bufcart> cartList = cartRepo.findByEmail(user.getEmail());
		
		Orders order = new Orders();
		order.setUserId(user.getId());
		
		List<OrderDetails> orderDetailList = new ArrayList<>();
		for(Bufcart cartDetail : cartList) {
			OrderDetails orderDetail = new OrderDetails();
			orderDetail.setProductId(cartDetail.getProductId());
			orderDetail.setPrice(100.0);
			orderDetail.setQuantity(cartDetail.getQuantity());
			orderDetailList.add(orderDetail);
			
		}
		
		order.setOrderDetails(orderDetailList);
		
		orderRepo.save(order);
		
		
	}

}
