package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipements")  //chemain du controller  soo https://localhost:8080/equipement/aficherTouteEquipement
public class EquipementController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IEquipementServiceImp a ou private final IEquipementService a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IEquipementService equipementService;
    @GetMapping(("/afficherTouteEquipement"))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Equipement> getALLEquipement() {
        return equipementService.afficherEquipement();

    }

    @GetMapping("afficherEquipementById/{id}")
    public Equipement getEquipementById(@PathVariable Long id){
        return  equipementService.afficherEquipementById(id);
    }

    @PostMapping("ajouterEquipement")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Equipement ajouterEquipement(@RequestBody Equipement equipement){
        return equipementService.ajouterEquipement(equipement);
    }
    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement){
        return equipementService.modifierEquipement(equipement);
    }
    @DeleteMapping("/supprimerEquipement/{idEquipement}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerEquipement(@PathVariable Long idEquipement){
        equipementService.supprimerEquipement(idEquipement);
    }

}
