package fr.miage.toulouse.vamarcher.randoadmin.service;

import fr.miage.toulouse.vamarcher.randoadmin.model.Rando;
import org.springframework.stereotype.Service;

@Service
public interface MembreService {

    /**
     * Liste toutes les Randos de VaMarcher
     * @return
     */
    Iterable<Rando> listerRandos();

    /**
     * Voter pour une date d'une rando
     * @param idRando
     * @param date
     * @param userId
     * @return vote OK| KO
     */
    String voter(String idRando, String date, Integer userId);

    /**
     * Inscrption d'un randonneur à une randonnée.
     * @param idRando
     * @param userId
     * @return Inscription validée | KO
     */
    String inscrire(String idRando, Integer userId);

    /**
     * désinscrire un membre d'une rando
     * @param idRando
     * @param userId
     * @return L'utilisteur n'est pas inscrit | KO | Désinscription confirmée
     */
    String desinscrire(String idRando, Integer userId);


}
