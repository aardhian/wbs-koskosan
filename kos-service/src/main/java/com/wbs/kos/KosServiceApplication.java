package com.wbs.kos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KosServiceApplication.class, args);
	}

}
