package fr.miage.toulouse.membersAdmin.model;

import java.util.ArrayList;

public class Membre {

    private static ArrayList<Membre> lesMembres = new ArrayList<>();
    private String nom, prenom, mail, username, password;
    private int licence, id;
    private double niveau;
    private Adresse adresse;
    private CertificatMedical certificatMedical;

    public static Membre getMembreById(int idMembre){
        return getLesMembres().get(idMembre);
    }

    public static ArrayList<Membre> getLesMembres() {
        return lesMembres;
    }

    public static void setLesMembres(ArrayList<Membre> lesMembres) {
        Membre.lesMembres = lesMembres;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLicence() {
        return licence;
    }

    public void setLicence(int licence) {
        this.licence = licence;
    }

    public double getNiveau() {
        return niveau;
    }

    public void setNiveau(double niveau) {
        this.niveau = niveau;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public CertificatMedical getCertificatMedical() {
        return certificatMedical;
    }

    public void setCertificatMedical(CertificatMedical certificatMedical) {
        this.certificatMedical = certificatMedical;
    }

    public Membre(String nom, String prenom, String mail, String username, String password, int licence, double niveau, Adresse adresse, CertificatMedical certificatMedical) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.licence = licence;
        this.niveau = niveau;
        this.adresse = adresse;
        this.certificatMedical = certificatMedical;
    }

    public Membre(String nom, String prenom, String mail, String username, String password, int licence, double niveau) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.licence = licence;
        this.niveau = niveau;
    }

    public Membre() {
    }
}
