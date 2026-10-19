package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule ;
import tn.esprit.autoloc.service.IVehiculeService ;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicules ")  //chemain du controller  soo https://localhost:8080/vehicule /aficherTouteVehicule 
public class VehiculeController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IVehicule ServiceImp a ou private final IVehicule Service a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IVehiculeService VehiculeService ;
    @GetMapping(("/afficherTouteVehicule "))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Vehicule > getALLVehicule () {
        return VehiculeService .afficherVehicule();

    }

    @GetMapping("afficherVehiculeById/{id}")
    public Vehicule  getVehiculeById(@PathVariable Long id){
        return  VehiculeService .afficherVehiculeById(id);
    }

    @PostMapping("ajouterVehicule ")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Vehicule  ajouterVehicule (@RequestBody Vehicule  vehicule ){
        return VehiculeService .ajouterVehicule (vehicule );
    }
    @PutMapping("/modifierVehicule ")
    public Vehicule  modifierVehicule (@RequestBody Vehicule  vehicule ){
        return VehiculeService .modifierVehicule (vehicule );
    }
    @DeleteMapping("/supprimerVehicule /{idVehicule}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerVehicule (@PathVariable Long idVehicule ){
        VehiculeService.supprimerVehicule (idVehicule );
    }

}
