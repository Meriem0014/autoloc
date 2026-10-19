package tn.esprit.autoloc.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IAgenceService {
    //signature du crud
    // type De Retour nomMethode(type var )
    Agence ajouterAgence(Agence agence);
    Agence modifierAgence(Agence agence);
    List<Agence> afficherToutesAgences();
    Agence afficherAgenceById(Long id );
    void supprimerAgence(Long id);
}
