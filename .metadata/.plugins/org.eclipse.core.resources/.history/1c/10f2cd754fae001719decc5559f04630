package com.myapp.cloud.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentSink {
	String CHANNEL_NAME="paymentsChannel";
	@Input
	SubscribableChannel paymentsChannel();

}
