package com.myapp.cloud.messaging;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.myapp.cloud.model.Payment;


@MessagingGateway

public interface PaymentGateway {
	@Gateway(requestChannel=PaymentSource.CHANNEL_NAME)
	void publish (Payment payment);

}
