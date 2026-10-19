package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;
@Service
@AllArgsConstructor
// implemente toute les methodes de service
public class IAgenceServiceImp implements IAgenceService{
    //injection du bean par constructeur
    private final AgenceRepository agenceRepository; //SO WE COULD USE LES METHODES OFFERTES

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence); // non du instance du violet , save() enregistre dans la base de donne
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> afficherToutesAgences() {return agenceRepository.findAll();
    }

    @Override
    public Agence afficherAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);// cad si mayl9ahech id cest null ou else elle reste rouge
    }

    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);

    }
}
