package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employes")  //chemain du controller  soo https://localhost:8080/employe/aficherTouteEmploye
public class EmployeController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IEmployeServiceImp a ou private final IEmployeService a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IEmployeService employeService;
    @GetMapping(("/afficherTouteEmploye"))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Employe> getALLEmploye() {
        return employeService.afficherEmploye();

    }

    @GetMapping("afficherEmployeById/{id}")
    public Employe getEmployeById(@PathVariable Long id){
        return  employeService.afficherEmployeById(id);
    }

    @PostMapping("ajouterEmploye")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Employe ajouterEmploye(@RequestBody Employe employe){
        return employeService.ajouterEmploye(employe);
    }
    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe){
        return employeService.modifierEmploye(employe);
    }
    @DeleteMapping("/supprimerEmploye/{idEmploye}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerEmploye(@PathVariable Long idEmploye){
        employeService.supprimerEmploye(idEmploye);
    }

}
