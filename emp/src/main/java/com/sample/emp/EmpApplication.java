package com.sample.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.context.annotation.Bean;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

	import com.sample.emp.security.AppProperties;

	@SpringBootApplication
	public class EmpApplication
	{

		public static void main(String[] args)
		{
			SpringApplication.run(EmpApplication.class, args);
		}

		@Bean
		public BCryptPasswordEncoder bcryptPasswordEncoder()
		{
			return  new BCryptPasswordEncoder();
		}
		
		@Bean
		public SpringApplicationContext SpringApplicationContext()
		{
			return  new SpringApplicationContext();
		}
		
		@Bean
		public AppProperties AppProperties()
		{
			return  new AppProperties();
		}

	}

