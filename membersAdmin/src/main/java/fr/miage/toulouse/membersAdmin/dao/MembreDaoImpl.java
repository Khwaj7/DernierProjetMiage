package fr.miage.toulouse.membersAdmin.dao;

import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MembreDaoImpl implements MembreDao {
    public static List<Membre> membres = new ArrayList<>();

    static {
        membres.add(new Membre("Jugnot", "Gérard", "jug@mail.com", "gege", "pass", 0, 0));
    }

    @Override
    public List<Membre> findAll() {
        return membres;
    }

    @Override
    public Membre findById(int id) {
        return membres.get(0);
    }

    @Override
    public Membre save(Membre memb) {
        membres.add(memb);
        return memb;
    }
}
