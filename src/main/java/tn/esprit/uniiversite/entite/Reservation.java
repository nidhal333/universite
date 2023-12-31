package tn.esprit.uniiversite.entite;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Reservation")

public class Reservation implements Serializable {
    @Id
    //@GeneratedValue
    private String id;
    @Column(name = "annee_universitaire")
    private LocalDate anneuniversitaire;
    @Column(name = "est_valide")
    private Boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

}
