package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;
@Tag(name = " Contrat", description = "operation sur les contrats ")
@RestController
@AllArgsConstructor
@RequestMapping("/contrats")  //chemain du controller  soo https://localhost:8080/contrat/aficherTouteContrat
public class ContratController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IContratServiceImp a ou private final IContratService a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IContratService contratService;
    @Operation(summary = "afficher la liste des contrat ")
    @GetMapping(("/afficherTouteContrat"))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Contrat> getALLContrat() {
        return contratService.afficherContrat();

    }

    @Operation(summary = "affficher la liste des contrat ")
    @GetMapping("afficherContratById/{id}")
    public Contrat getContratById(@PathVariable Long id){
        return  contratService.afficherContratById(id);
    }

    @Operation(summary = "ajouter  contrat sans donne id ")
    @PostMapping("ajouterContrat")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Contrat ajouterContrat(@RequestBody Contrat contrat){
        return contratService.ajouterContrat(contrat);
    }
    @Operation(summary = "modifier  contrat ")
    @PutMapping("/modifierContrat")
    public Contrat modifierContrat(@RequestBody Contrat contrat){
        return contratService.modifierContrat(contrat);
    }
    @Operation(summary = "suprimer  contrat par id ")
    @DeleteMapping("/supprimerContrat/{idContrat}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerContrat(@PathVariable Long idContrat){
        contratService.supprimerContrat(idContrat);
    }

}
