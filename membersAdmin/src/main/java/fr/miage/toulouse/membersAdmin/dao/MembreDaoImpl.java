package fr.miage.toulouse.membersAdmin.dao;

import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MembreDaoImpl implements MembreDao {
    public static List<Membre>products=new ArrayList<>();
    static {
        products.add(new Membre("Jugnot", "Gérard", "jug@mail.com", "gege", "pass", 0, 0);
    }
    @Override
    public List<MembreDao> findAll() {
        return null;
    }

    @Override
    public MembreDao findById(int id) {
        return null;
    }

    @Override
    public MembreDao save(MembreDao membreDao) {
        return null;
    }
}
