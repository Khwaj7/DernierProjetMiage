package fr.miage.toulouse.membersAdmin.dao;

import fr.miage.toulouse.membersAdmin.model.Membre;

import java.util.List;

public interface MembreDao {
    public List<Membre> findAll();
    public Membre findById(int id);
    public Membre save(Membre membre);
}
