package fr.miage.toulouse.membersAdmin.services;

import fr.miage.toulouse.membersAdmin.dao.MembreDao;
import fr.miage.toulouse.membersAdmin.dao.TeamLeaderDao;
import fr.miage.toulouse.membersAdmin.model.Membre;
import fr.miage.toulouse.membersAdmin.model.TeamLeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    MembreDao membreDao;

    @Autowired
    TeamLeaderDao teamLeaderDao;

    @Override
    public Iterable<Membre> listerMembres() {
        return membreDao.findAll();
    }

    @Override
    public String promoteTeamLeader(Integer userID) {
        try{
            Optional<Membre> membre = membreDao.findById(userID);
            TeamLeader teamLeader = new TeamLeader(membre.get());
            teamLeaderDao.save(teamLeader);
            return "Promotion validée";
        } catch (Exception e){
            return "KO";
        }
    }

    @Override
    public Integer stats() {
        List<Membre> membres = (List<Membre>) membreDao.findAll();
        return membres.size();
    }

    @Override
    public Iterable<TeamLeader> listeTeamLeaders() {
        return teamLeaderDao.findAll();
    }
}
