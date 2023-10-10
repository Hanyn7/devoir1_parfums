package com.hanin.parfum;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.hanin.parfum.entities.Famille;
import com.hanin.parfum.entities.Parfum;


@SpringBootApplication
public class ParfumApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(ParfumApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Parfum.class,Famille.class);
	}
	

	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}

}

