package fr.miage.toulouse.membersAdmin.model;

import java.util.Date;

public class CertificatMedical {
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
