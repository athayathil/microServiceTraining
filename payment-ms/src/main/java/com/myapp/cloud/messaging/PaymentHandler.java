package com.myapp.cloud.messaging;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.cloud.model.Payment;
import com.myapp.cloud.repository.PaymentRepository;

@Service
public class PaymentHandler {
	@Autowired
	private PaymentRepository paymentRepository;
	
	@StreamListener(PaymentSink.CHANNEL_NAME)
	@Transactional(propagation=Propagation.REQUIRED)
	public void subscribe(Payment payment) {
		paymentRepository.save(payment);
		
	}

}
