package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.EquipementRepo;
import tn.esprit.autoloc.repository.MaintenanceRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class IMaintenanceServiceImp implements IMaintenanceService{
    private final MaintenanceRepo maintenanceRepo;
    @Override
    public Maintenance  ajouterMaintenance(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    @Override
    public List<Maintenance> afficherMaintenance() {
        return maintenanceRepo.findAll();
    }

    @Override
    public Maintenance afficherMaintenanceById(Long id) {
        return maintenanceRepo.findById(id).orElse(null);
    }

    @Override
    public void supprimerMaintenance(Long id) {
        maintenanceRepo.deleteById(id);

    }
}
