package fr.miage.toulouse.randouser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.List;

@Document(collection = "rando")
public class Rando {

    @Id
    private String id;

    private Timestamp dateRetenue;

    private List<Timestamp> propositionsDates;

    private String pointDepart;

    private String description;

    private String distance;

    private String duree;

    private String denivele;

    private String niveau;

    private List<Integer> participants;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDateRetenue() {
        return dateRetenue;
    }

    public void setDateRetenue(Timestamp dateRetenue) {
        this.dateRetenue = dateRetenue;
    }

    public List<Timestamp> getPropositionsDates() {
        return propositionsDates;
    }

    public void setPropositionsDates(List<Timestamp> propositionsDates) {
        this.propositionsDates = propositionsDates;
    }

    public String getPointDepart() {
        return pointDepart;
    }

    public void setPointDepart(String pointDepart) {
        this.pointDepart = pointDepart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDenivele() {
        return denivele;
    }

    public void setDenivele(String denivele) {
        this.denivele = denivele;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public List<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Integer> participants) {
        this.participants = participants;
    }

    public Rando(){

    }

    public Rando(String id, Timestamp dateRetenue, List<Timestamp> propositionsDates, String pointDepart, String description,
                 String distance, String duree, String denivele, String niveau, List<Integer> participants) {
        this.id = id;
        this.dateRetenue = dateRetenue;
        this.propositionsDates = propositionsDates;
        this.pointDepart = pointDepart;
        this.description = description;
        this.distance = distance;
        this.duree = duree;
        this.denivele = denivele;
        this.niveau = niveau;
        this.participants = participants;
    }
}
