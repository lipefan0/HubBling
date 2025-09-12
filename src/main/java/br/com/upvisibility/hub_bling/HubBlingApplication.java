package br.com.upvisibility.hub_bling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HubBlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HubBlingApplication.class, args);
	}

}
