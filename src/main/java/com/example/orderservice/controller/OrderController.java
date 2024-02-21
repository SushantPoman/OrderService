package com.example.orderservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.dao.Orders;
import com.example.orderservice.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	
	@GetMapping("/greet")
	public String greet(){
		return "Hello from OrderService instance2";
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		return (List<Orders>) orderRepository.findAll();
	}
	
	@GetMapping("/orders/{oid}")
	public Orders getOrderByOid(@PathVariable Integer oid){
		return  orderRepository.findById(oid).orElseThrow(() -> new RuntimeException("No order placed "+oid));
	}
	
	@PostMapping("/save")
	public Orders saveOrder(@RequestBody Orders order) {
		return orderRepository.save(order);
	}
	
	@GetMapping("/orderByName/{username}")
	public List<Orders> getOrdersByUsername(@PathVariable String username){
		log.info("From OrderService");
		return orderRepository.findByUsername(username);
	}
	
}
