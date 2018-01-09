package com.myapp.cloud.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PaymentSource {
	String CHANNEL_NAME="paymentsChannel";
	@Output
	MessageChannel 	paymentsChannel();

}
