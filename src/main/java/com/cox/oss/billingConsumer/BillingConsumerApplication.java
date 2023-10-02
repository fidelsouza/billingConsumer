package com.cox.oss.billingConsumer;

import com.cox.oss.billingConsumer.services.BillingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EntityScan({ "com.cox.oss.billingService.interfaces.entities"})
@ComponentScan({ "com.cox.oss.billingConsumer.*","com.cox.oss.billingConsumer.services"})
public class BillingConsumerApplication {

	private static Logger log = LoggerFactory.getLogger(BillingConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BillingConsumerApplication.class, args);
		log.info("STARTING APP");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
