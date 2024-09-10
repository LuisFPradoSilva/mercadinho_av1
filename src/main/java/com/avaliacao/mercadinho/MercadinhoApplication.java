package com.avaliacao.mercadinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.avaliacao.domains", "com.avaliacao.domains.enums"})
@ComponentScan(basePackages = "com.avaliacao")
@EnableJpaRepositories(basePackages = "com.avaliacao.repositories")
@SpringBootApplication
public class MercadinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadinhoApplication.class, args);
	}

}
