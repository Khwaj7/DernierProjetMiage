package fr.miage.toulouse.vamarcher.randoadmin.service;

import fr.miage.toulouse.vamarcher.randoadmin.model.Rando;
import org.springframework.stereotype.Service;

@Service
public interface TeamLeaderService {

    /**
     * Ajouter une nouvelle rando
     * @param rando
     * @return
     */
    Rando proposerRando(Rando rando);

    /**
     * Termine les votes et inscrit les participant qui ont choisi
     * la date retenue
     * @param randoId
     * @return Rando | null
     */
    Rando cloturerVote(String randoId);

    /**
     * Termine l'organisation d'une randonnée
     * @param randoId
     * @return Rando |null
     */
    Rando cloturerOrga(String randoId);

    /**
     * Supprime une rando qui ne pourra pas avoir lieu
     * @param randoId
     * @return Done | NOK
     */
    String annulerRando(String randoId);

}
