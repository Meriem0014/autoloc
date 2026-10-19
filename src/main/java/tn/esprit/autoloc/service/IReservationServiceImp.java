package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepo;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IReservationServiceImp  implements IReservationService {
    private final ReservationRepo reservationRepo;
    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public List<Reservation> afficherReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation afficherReservationById(Long id) {
        return reservationRepo.findById(id).orElse(null);
    }

    @Override
    public void supprimerReservation(Long id) {
        reservationRepo.deleteById(id);

    }
}
