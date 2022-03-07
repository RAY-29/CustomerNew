package com.account.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {
	
	@Bean
	public ValidatingMongoEventListener validatingMongoEventListener() {
		System.out.println("Hello1");
		return new ValidatingMongoEventListener(validator());
	}
    @Bean
	public LocalValidatorFactoryBean validator() {
		// TODO Auto-generated method stub
    	System.out.println("Hello");
		return new LocalValidatorFactoryBean();
	}
	

}
