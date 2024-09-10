package com.avaliacao.mercadinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.avaliacao.domains", "com.avaliacao.domains.enums"})
@SpringBootApplication
public class MercadinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadinhoApplication.class, args);
	}

}
