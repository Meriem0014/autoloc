package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")  //chemain du controller  soo https://localhost:8080/reservation/aficherTouteReservation
public class ReservationController {
    //on expose des methodes implimente en couches service (besoin instance du class service pour utiliser ses methodes )
    // creeer des end-point

   // private final IReservationServiceImp a ou private final IReservationService a MAIS ON TRAVAIL PAR INTERFACE POUR FAIBLE COUPLAGE

    private final IReservationService reservationService;
    @GetMapping(("/afficherTouteReservation"))
    //exposer les methodes : @postMapping=ajouter/inserer new obj   @putMapping=modifier  @getMapping =recuperer    @deleteMapping
    public List<Reservation> getALLReservation() {
        return reservationService.afficherReservation();

    }

    @GetMapping("afficherReservationById/{id}")
    public Reservation getReservationById(@PathVariable Long id){
        return  reservationService.afficherReservationById(id);
    }

    @PostMapping("ajouterReservation")
    //indiquer a spring qu on va inserer un new obj ds BD == @ResquestBody
    public Reservation ajouterReservation(@RequestBody Reservation reservation){
        return reservationService.ajouterReservation(reservation);
    }
    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation){
        return reservationService.modifierReservation(reservation);
    }
    @DeleteMapping("/supprimerReservation/{idReservation}")
    //@Pathvariable == il va prendre une info de URL ici id pour utiliser dans la methode
    public void supprimerReservation(@PathVariable Long idReservation){
        reservationService.supprimerReservation(idReservation);
    }

}
