package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idVehicule;
    String immatricule,marque,modele;
    CategorieVehicule categorie;
    BigDecimal tarifJournalier;
    StatutVehicule status;
    @ManyToMany(fetch=FetchType.EAGER)
    List<Equipement>  equipements = new ArrayList<>();
    @ManyToOne
    private Agence agence;
    @OneToMany(mappedBy = "vehicule")
    private List<Maintenance> maintenances = new ArrayList<>();


}
// - cest private