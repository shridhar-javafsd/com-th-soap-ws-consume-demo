
package com.th.ws.consume.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.th.ws.consume.demo.GetEmployeeResponse;

@SpringBootApplication
public class App {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	CommandLineRunner lookup(EmployeeClient quoteClient) {
		return args -> {

			GetEmployeeResponse response = quoteClient.getEmployee(101);
			LOG.info(response.getEmployee().getEmployeeId() + " " + response.getEmployee().getFirstName() + " "
					+ response.getEmployee().getSalary());

		};
	}
}
