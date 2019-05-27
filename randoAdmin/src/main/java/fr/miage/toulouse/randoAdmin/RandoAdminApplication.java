package fr.miage.toulouse.randoAdmin;

import fr.miage.toulouse.randoAdmin.controller.randoAdminController;
import fr.miage.toulouse.randoAdmin.model.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class RandoAdminApplication {
	private static final Logger log = LoggerFactory.getLogger(RandoAdminApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(RandoAdminApplication.class, args);
	}


	//OBJECTIF ICI :
	//consommer le webservice /membre/{id} du projet MembresAdmin
	//pour savoir si l'id donné par l'utilisateur existe bien.
	@Autowired
	RestTemplate rest;
	@Bean
	public RestTemplate rest(){
		return new RestTemplate();
	}

	@GetMapping("/membres")
	String getMembres() {
		return rest().getForObject("http://localhost:8080/membres", String.class);
	}

}
