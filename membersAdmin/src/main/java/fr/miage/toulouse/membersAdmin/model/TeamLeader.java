package fr.miage.toulouse.membersAdmin.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TeamLeader extends Membre {

    public TeamLeader(){

    }

    public TeamLeader(Membre membre){
        super(membre.getNom(), membre.getPrenom(), membre.getMail(), membre.getUsername(), membre.getPassword(), membre.getLicence(), membre.getNiveau(), membre.getAdresse(), membre.getCertificatMedical());
    }
}
