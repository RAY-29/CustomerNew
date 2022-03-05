package com.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@SpringBootApplication
public class CustomerServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServer2Application.class, args);
	}

}
