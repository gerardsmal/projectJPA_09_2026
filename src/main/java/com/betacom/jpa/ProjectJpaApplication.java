package com.betacom.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.betacom.jpa.process.ProcessJPA;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@SpringBootApplication
public class ProjectJpaApplication {

	private final ProcessJPA pr;	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectJpaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner startup() {
		return args -> {
			log.debug("Start ProjectJpaApplication ***");
			//pr.createSocio();
			//pr.listSocio();
			//pr.setCertificato();
			//pr.listSocio();
			//pr.updatSocio();
			pr.deleteSocio();
			//pr.setCertificato();
			pr.listSocio();
		};

	}


}
