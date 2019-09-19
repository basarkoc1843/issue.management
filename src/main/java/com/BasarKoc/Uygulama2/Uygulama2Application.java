package com.BasarKoc.Uygulama2;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@SpringBootApplication
public class Uygulama2Application {

	public static void main(String[] args) {
		SpringApplication.run(Uygulama2Application.class, args);
	}
	@Bean
  public ModelMapper getModelMapper() {

		ModelMapper modelMapper=new ModelMapper();

		return modelMapper;
  }
}
