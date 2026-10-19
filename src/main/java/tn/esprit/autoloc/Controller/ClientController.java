package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")  //chemain du controller  soo https://localhost:8080/client/aficherTouteClient
public class ClientController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IClientServiceImp a ou private final IClientService a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IClientService clientService;
    @GetMapping(("/afficherTouteClient"))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Client> getALLClient() {
        return clientService.afficherClient();

    }

    @GetMapping("afficherClientById/{id}")
    public Client getClientById(@PathVariable Long id){
        return  clientService.afficherClientById(id);
    }

    @PostMapping("ajouterClient")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Client ajouterClient(@RequestBody Client client){
        return clientService.ajouterClient(client);
    }
    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client){
        return clientService.modifierClient(client);
    }
    @DeleteMapping("/supprimerClient/{idClient}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerClient(@PathVariable Long idClient){
        clientService.supprimerClient(idClient);
    }

}
