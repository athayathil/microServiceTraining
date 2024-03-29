package com.myapp.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import com.myapp.cloud.messaging.PaymentSource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableBinding(PaymentSource.class)

public class OrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMsApplication.class, args);
	}

	@Bean
	public Docket newAPi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("order-ms")
				.apiInfo(apiInfo())
				.select()
				.paths(PathSelectors.regex(("/orders.*")))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Order-MS")
				.description("order microservice crud")
				.termsOfServiceUrl("http://in.ibm.com")
				.contact("Anjali")
				.license("OSS")
				.version("1.0")
				.build();
	}
}
