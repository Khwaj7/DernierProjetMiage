package fr.miage.toulouse.randouser.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "vote")
public class Vote {

    @Id
    private String id;

    @DBRef
    private Rando rando;

    private Integer userId;

    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rando getRando() {
        return rando;
    }

    public void setRando(Rando rando) {
        this.rando = rando;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vote(){

    }

    public Vote(Rando rando, Integer userId, Date date) {
        this.rando = rando;
        this.userId = userId;
        this.date = date;
    }
}