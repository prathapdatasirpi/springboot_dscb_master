package com.datasirpi.dschatbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.datasirpi.dschatbox"})
@ComponentScan("com.datasirpi.dschatbox.*")
public class DschatboxApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DschatboxApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
