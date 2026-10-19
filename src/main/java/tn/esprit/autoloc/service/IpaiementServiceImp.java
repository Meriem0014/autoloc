package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.MaintenanceRepo;
import tn.esprit.autoloc.repository.PaiementRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class IpaiementServiceImp implements IPaiementService {
    private final PaiementRepo paiementRepo;

    @Override
    public Paiement ajouterPaiement(Paiement Paiement) {
        return paiementRepo.save(Paiement) ;
    }

    @Override
    public Paiement modifierPaiement(Paiement paiement) {
        return paiementRepo.save(paiement) ;
    }

    @Override
    public List<Paiement> afficherPaiement() {
        return paiementRepo.findAll();
    }

    @Override
    public Paiement afficherPaiementById(Long id) {
        return paiementRepo.findById(id).orElse(null);
    }

    @Override
    public void supprimerPaiement(Long id) {
        paiementRepo.deleteById(id);

    }
}
