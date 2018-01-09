package com.myapp.cloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.cloud.api.client.OrderClient;
import com.myapp.cloud.model.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderClient orderClient;

	@Override

	// @HystrixCommand(
	// fallbackMethod = "findAllFallback",
	// commandProperties={
	// @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="20"),
	// @HystrixProperty(name="circuitBreaker.sleepWindowInmilliseconds",value="1000")
	// }
	// )
	@HystrixCommand(fallbackMethod = "findAllFallback")

	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderClient.findAll();
	}

	public List<Order> findAllFallback() {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		Order order1 = new Order();
		order1.setName("dummy1");
		Order order2 = new Order();
		order1.setName("dummy2");
		list.add(order1);
		list.add(order2);
		return list;
	}

	@Override
	public String placeNewOrder(Order order) {
		// TODO Auto-generated method stub
		return orderClient.placeNewOrder(order);
	}

}
