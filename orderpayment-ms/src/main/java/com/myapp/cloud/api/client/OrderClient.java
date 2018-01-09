package com.myapp.cloud.api.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myapp.cloud.model.Order;

@FeignClient("ORDER-MS")
public interface OrderClient {
	@GetMapping("/orders")
	List<Order> findAll();

	@PostMapping("/orders")
	String placeNewOrder(@RequestBody Order order);

}
