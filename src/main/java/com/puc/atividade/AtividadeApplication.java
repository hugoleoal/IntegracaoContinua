package com.puc.atividade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.puc.controller","com.puc.service"})
@EnableJpaRepositories("com.puc.repository")
@EntityScan(basePackages = "com.puc.entity")
@SpringBootApplication
public class AtividadeApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(AtividadeApplication.class, args);

	}
}
