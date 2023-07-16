package com.tkgroupbd.pusti.api;

import com.tkgroupbd.pusti.api.data.repository.DepotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PustiApiApplicationTests {

	@Autowired
	DepotRepository repository;
	@Test
	void contextLoads() {
		System.out.println("Begain");
		long count = repository.count();
		System.out.println("Elements : "+ count);
		repository.findAll().forEach(System.out::println);
		System.out.println("End");
	}





}
