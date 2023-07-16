package com.tkgroupbd.pusti.api;

import com.tkgroupbd.pusti.api.service.depot.DepotServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class PustiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PustiApiApplication.class, args);


	}
}
