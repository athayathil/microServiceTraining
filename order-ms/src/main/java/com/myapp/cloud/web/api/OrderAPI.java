package com.myapp.cloud.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.cloud.messaging.PaymentGateway;
import com.myapp.cloud.model.Order;
import com.myapp.cloud.repository.OrderRepository;

@RestController
public class OrderAPI {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentGateway paymentGateway;

	// @RequestMapping(value="/orders,method=RequestMethod.POST)
	@PostMapping(value = "/orders")
	public ResponseEntity<String> save(@RequestBody Order order) {
		paymentGateway.publish(order.getPayment());
		orderRepository.save(order);
		return new ResponseEntity<String>("Order Created", HttpStatus.CREATED);
	}

	@PutMapping(value = "/orders/{id}")
	public ResponseEntity<String> update(@PathVariable("id") String id, @RequestBody Order order) {
		Order existingOrder = orderRepository.findOne(id);
		existingOrder.setName(order.getName());
		existingOrder.setPrice(order.getPrice());
		orderRepository.save(existingOrder);
		return new ResponseEntity<String>("Order updated", HttpStatus.OK);
	}

	@GetMapping(value = "/orders/{id}")
	public ResponseEntity<Order> findById(@PathVariable("id") String id) {
		Order existingOrder = orderRepository.findOne(id);
		return new ResponseEntity<Order>(existingOrder, HttpStatus.OK);
	}

	@GetMapping(value = "/orders")
	public ResponseEntity<List<Order>> findAll() {
		 List <Order> existingOrder = orderRepository.findAll();
//		List<Order> existingOrder = new ArrayList<>();
//		Order order = new Order();
//		order.setId("000");
//		order.setName("000");
//		order.setPrice("0.0");
//		existingOrder.add(order);

		return new ResponseEntity<List<Order>>(existingOrder, HttpStatus.OK);
	}

	@DeleteMapping(value = "/orders/{id}")
	public ResponseEntity<String> remove(@PathVariable("id") String id) {
		orderRepository.delete(id);
		return new ResponseEntity<String>("Order deleted", HttpStatus.NO_CONTENT);
	}

}
