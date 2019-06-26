package fr.miage.toulouse.membersAdmin.services;

import fr.miage.toulouse.membersAdmin.dao.MembreDao;
import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private MembreDao membreDao;

    public Membre inscription(Membre membre){
        return membreDao.save(membre);
    }

    @Override
    public Membre getOneMembre(Integer id) {
        try{
            Optional<Membre> membre = membreDao.findById(id);
            return membre.get();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Membre login(String login, String password) {
        try{
            Membre membre = membreDao.findByLogin(login);
            boolean auth = Membre.checkPassword(password, membre.getEncryptedPassword());
            if (auth) return membre;
            else return null;
        } catch (Exception e){
            return null;
        }
    }

}
