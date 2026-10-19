package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenances")  //chemain du controller  soo https://localhost:8080/maintenance/aficherTouteMaintenance
public class MaintenanceController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IMaintenanceServiceImp a ou private final IMaintenanceService a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IMaintenanceService maintenanceService;
    @GetMapping(("/afficherTouteMaintenance"))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Maintenance> getALLMaintenance() {
        return maintenanceService.afficherMaintenance();

    }

    @GetMapping("afficherMaintenanceById/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id){
        return  maintenanceService.afficherMaintenanceById(id);
    }

    @PostMapping("ajouterMaintenance")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance){
        return maintenanceService.ajouterMaintenance(maintenance);
    }
    @PutMapping("/modifierMaintenance")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance){
        return maintenanceService.modifierMaintenance(maintenance);
    }
    @DeleteMapping("/supprimerMaintenance/{idMaintenance}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerMaintenance(@PathVariable Long idMaintenance){
        maintenanceService.supprimerMaintenance(idMaintenance);
    }

}
