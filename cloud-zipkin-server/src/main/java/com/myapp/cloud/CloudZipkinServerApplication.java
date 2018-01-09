package com.myapp.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class CloudZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZipkinServerApplication.class, args);
	}
}
