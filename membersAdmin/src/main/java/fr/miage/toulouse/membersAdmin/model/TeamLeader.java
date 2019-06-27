package fr.miage.toulouse.membersAdmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeamLeader extends Membre {

    public TeamLeader(){

    }

    public TeamLeader(Membre membre){
        super(membre.getNomMembre(), membre.getPrenomMembre(), membre.getMailMembre(), membre.getLogin(), membre.getEncryptedPassword(), membre.getNumLicence(), membre.getNiveau(), membre.getAdresse(), membre.getCertificatMedical());
    }
}
