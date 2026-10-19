package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EmployeRepo;
import tn.esprit.autoloc.repository.EquipementRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class IEquipementServiceImp implements IEquipementService{
    private final EquipementRepo equipementRepo;

    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementRepo.save(equipement);
    }

    @Override
    public Equipement modifierEquipement(Equipement equipement) {
        return equipementRepo.save(equipement);
    }

    @Override
    public List<Equipement> afficherEquipement() {
        return equipementRepo.findAll();
    }

    @Override
    public Equipement afficherEquipementById(Long id) {
        return equipementRepo.findById(id).orElse(null);
    }

    @Override
    public void supprimerEquipement(Long id) {
        equipementRepo.deleteById(id);

    }
}
