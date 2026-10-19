package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Contrat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IContractServiceImp implements IContratService {
    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return null;
    }

    @Override
    public Contrat modifierContrat(Contrat contract) {
        return null;
    }

    @Override
    public List<Contrat> afficherContrat() {
        return List.of();
    }

    @Override
    public Contrat afficherContratById(Long id) {
        return null;
    }

    @Override
    public void supprimerContrat(Long id) {

    }
}
