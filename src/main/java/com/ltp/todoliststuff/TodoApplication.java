package com.ltp.todoliststuff;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import lombok.AllArgsConstructor;

@SpringBootApplication @AllArgsConstructor
@EnableAutoConfiguration
public class TodoApplication  {


	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}	


}
 