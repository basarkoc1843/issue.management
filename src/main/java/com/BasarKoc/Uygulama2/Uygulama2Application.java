package com.BasarKoc.Uygulama2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Uygulama2Application {

	public static void main(String[] args) {
		SpringApplication.run(Uygulama2Application.class, args);
	}
	@Bean
  public ModelMapper getModelMapper() {
		return new ModelMapper();
  }
}
