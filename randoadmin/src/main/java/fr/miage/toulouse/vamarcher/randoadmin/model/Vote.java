package fr.miage.toulouse.vamarcher.randoadmin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Document(collection = "vote")
public class Vote {

    @Id
    private String id;

    private Integer userId;

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Vote(Integer userId, Date date) {
        this.userId = userId;
        this.date = date;
    }
}
