package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;
import tn.esprit.autoloc.service.IAgenceServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agences")  //chemain du controller  soo https://localhost:8080/agence/aficherTouteAgence
public class AgenceController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IAgenceServiceImp a ou private final IAgenceService a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IAgenceService agenceService;
    @GetMapping(("/afficherTouteAgence"))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Agence> getALLAgence() {
        return agenceService.afficherToutesAgences();

    }

    @GetMapping("afficherAgenceById/{id}")
    public Agence getAgenceById(@PathVariable Long id){
        return  agenceService.afficherAgenceById(id);
    }

    @PostMapping("ajouterAgence")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Agence ajouterAgence(@RequestBody Agence agence){
        return agenceService.ajouterAgence(agence);
    }
    @PutMapping("/modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence){
        return agenceService.modifierAgence(agence);
    }
    @DeleteMapping("/supprimerAgence/{idAgence}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerAgence(@PathVariable Long idAgence){
        agenceService.supprimerAgence(idAgence);
    }

}
