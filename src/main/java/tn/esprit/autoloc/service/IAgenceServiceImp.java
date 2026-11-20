package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
// implemente toute les methodes de service
public class IAgenceServiceImp implements IAgenceService{
    //injection du bean par constructeur
    private final AgenceRepository agenceRepository; //SO WE COULD USE LES METHODES OFFERTES
    private final VehiculeRepository vehiculeRepository;

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

    @Override
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        Agence agenceSaved = agenceRepository.save(agence);

        agenceSaved.getVehicules().forEach(vehicule -> {
            vehicule.setAgence(agenceSaved);
        });

        vehiculeRepository.saveAll(agenceSaved.getVehicules());


        return agenceSaved;
    }

    @Override
    @Scheduled(fixedDelay = 120000)
    public void suivreNombreAgences() {
        List<Agence> agences = agenceRepository.findAll();
        System.out.println("===== SUIVI DES AGENCES =====");
        System.out.println("Nombre total d'agences : "
                + agences.size());
        System.out.println("Date et heure : " + LocalDateTime.now());
        System.out.println("=============================");
    }


}
