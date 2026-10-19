package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiements")  //chemain du controller  soo https://localhost:8080/paiement/aficherToutePaiement
public class PaiementController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IPaiementServiceImp a ou private final IPaiementService a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IPaiementService paiementService;
    @GetMapping(("/afficherToutePaiement"))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Paiement> getALLPaiement() {
        return paiementService.afficherPaiement();

    }

    @GetMapping("afficherPaiementById/{id}")
    public Paiement getPaiementById(@PathVariable Long id){
        return  paiementService.afficherPaiementById(id);
    }

    @PostMapping("ajouterPaiement")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Paiement ajouterPaiement(@RequestBody Paiement paiement){
        return paiementService.ajouterPaiement(paiement);
    }
    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement){
        return paiementService.modifierPaiement(paiement);
    }
    @DeleteMapping("/supprimerPaiement/{idPaiement}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerPaiement(@PathVariable Long idPaiement){
        paiementService.supprimerPaiement(idPaiement);
    }

}
