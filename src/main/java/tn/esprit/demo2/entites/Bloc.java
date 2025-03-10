package tn.esprit.demo2.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bloc {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;


    @ManyToOne
    @JoinColumn(name = "idUniversite")
    private Universite universite;

    @ManyToOne
   private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambres;



}
