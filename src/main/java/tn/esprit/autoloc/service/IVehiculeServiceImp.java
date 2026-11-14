package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepo;
import tn.esprit.autoloc.repository.PaiementRepo;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepo equipementRepo;
    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule afficherVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);

    }

    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepo.findById(idEquipement).get();

        vehicule.getEquipements().add(equipement);

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();

        Equipement equipement = equipementRepo.findById(idEquipement).get();

        vehicule.getEquipements().remove(equipement);

        return vehiculeRepository.save(vehicule);
    }
}
