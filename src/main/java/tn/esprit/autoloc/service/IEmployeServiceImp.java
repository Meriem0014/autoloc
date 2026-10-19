package tn.esprit.autoloc.service;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceImp implements IEmployeService {
    private final EmployeRepo employeRepo;
    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepo.save(employe) ;
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepo.save(employe);
    }

    @Override
    public List<Employe> afficherEmploye() {
        return employeRepo.findAll();
    }

    @Override
    public Employe afficherEmployeById(Long id) {
        return employeRepo.findById(id).orElse(null);
    }

    @Override
    public void supprimerEmploye(Long id) {
        employeRepo.deleteById(id);

    }
}
