package com.cacheApplication.Caache_Impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CaacheImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaacheImplApplication.class, args);
        System.out.println("Application started");
	}

}
