package tn.esprit.autoloc.service;

import org.springframework.lang.Contract;
import tn.esprit.autoloc.domain.Employe;

import java.util.List;

public interface IEmployeService {
    Employe ajouterEmploye(Employe employe);
    Employe modifierEmploye(Employe employe);
    List<Employe> afficherEmploye();
    Employe afficherEmployeById(Long id );
    void supprimerEmploye(Long id);
}
