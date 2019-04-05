package com.appliedsni.main;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@EnableJpaRepositories("com.appliedsni.repository")
@ComponentScan("com.appliedsni")
@EntityScan("com.appliedsni.model")
public class MockService {


	public static void main(String[] args) {
		SpringApplication.run(MockService.class, args);
	}
	
}
