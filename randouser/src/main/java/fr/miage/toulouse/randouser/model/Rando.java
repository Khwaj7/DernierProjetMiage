package fr.miage.toulouse.randouser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Document(collection = "rando")
public class Rando {
    @Id
    private String id;

    private Timestamp dateRetenue;

    private HashMap<Long, List<Vote>> propositionsDates;

    private String pointDepart;

    private String description;

    private String distance;

    private String duree;

    private String denivele;

    private String niveau;

    private float coutFixe;

    private float coutVariable;

    private String statut;

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

    public HashMap<Long, List<Vote>> getPropositionsDates() {
        return propositionsDates;
    }

    public void setPropositionsDates(HashMap<Long, List<Vote>> propositionsDates) {
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

    public float getCoutFixe() {
        return coutFixe;
    }

    public void setCoutFixe(float coutFixe) {
        this.coutFixe = coutFixe;
    }

    public float getCoutVariable() {
        return coutVariable;
    }

    public void setCoutVariable(float coutVariable) {
        this.coutVariable = coutVariable;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Rando(){

    }

    public Rando(String id, Timestamp dateRetenue, HashMap<Long, List<Vote>> propositionsDates, String pointDepart, String description,
                 String distance, String duree, String denivele, String niveau, List<Integer> participants, float coutFixe, float coutVariable, String statut) {
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
        this.coutFixe = coutFixe;
        this.coutVariable = coutVariable;
        this.statut = statut;
    }
}
