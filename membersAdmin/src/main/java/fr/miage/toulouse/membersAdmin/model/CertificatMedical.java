package fr.miage.toulouse.membersAdmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CertificatMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date dateEtablissement;

    public Date getDateEtablissement() {
        return dateEtablissement;
    }

    public void setDateEtablissement(Date dateEtablissement) {
        this.dateEtablissement = dateEtablissement;
    }

    public CertificatMedical(Date dateEtablissement) {
        this.dateEtablissement = dateEtablissement;
    }
}
