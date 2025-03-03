package tn.esprit.demo2.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;




    @ManyToOne
    private Etudiant etudiant;

    @ManyToMany
    private List<Etudiant> etudiants;

}
