package com.myapp.cloud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.cloud.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{
	List<Order> findByName(String name);

}
