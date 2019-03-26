package fr.miage.toulouse.membersAdmin.model;

public class Adresse {
    private int numero;
    private String rue, ville, pays;

    public Adresse() {
    }

    public Adresse(int numero, String rue, String ville, String pays) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.pays = pays;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
