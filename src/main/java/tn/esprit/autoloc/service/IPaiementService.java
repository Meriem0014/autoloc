package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement Paiement);
    Paiement modifierPaiement(Paiement paiement);
    List<Paiement> afficherPaiement();
    Paiement afficherPaiementById(Long id );
    void supprimerPaiement(Long id);

}
