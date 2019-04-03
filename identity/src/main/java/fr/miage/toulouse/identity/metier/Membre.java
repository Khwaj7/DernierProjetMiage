package fr.miage.toulouse.identity.metier;

import javax.persistence.*;

@Entity
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nomMembre;

    private String prenomMembre;

    private String mailMembre;

    private String login;

    private String numLicence;

    private String niveau;

    private String encryptedPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getMailMembre() {
        return mailMembre;
    }

    public void setMailMembre(String mailMembre) {
        this.mailMembre = mailMembre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(String numLicence) {
        this.numLicence = numLicence;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Membre() {
    }

    public Membre(String nomMembre, String prenomMembre, String mailMembre, String login, String numLicence, String niveau, String encryptedPassword) {
        this.nomMembre = nomMembre;
        this.prenomMembre = prenomMembre;
        this.mailMembre = mailMembre;
        this.login = login;
        this.numLicence = numLicence;
        this.niveau = niveau;
        this.encryptedPassword = encryptedPassword;
    }
}
