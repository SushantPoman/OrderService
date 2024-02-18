package com.example.orderservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.orderservice.dao.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

	
	public List<Orders> findByUsername(String username);

}
