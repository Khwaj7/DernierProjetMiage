package fr.miage.toulouse.membersAdmin;

import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MembersAdminApplication {
	public static void main(String[] args) {
		ArrayList<Membre> memb = new ArrayList<>();
		memb.add(new Membre("Jugnot", "Gérard", "jug@mail.com", "gege", "pass", 0, 12));
		Membre.setLesMembres(memb);
		SpringApplication.run(MembersAdminApplication.class, args);
	}
}
