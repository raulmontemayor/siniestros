package com.afirmeseguros.siniestros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCaching
@EnableAsync
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class App {


	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
