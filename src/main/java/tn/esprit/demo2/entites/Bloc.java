package tn.esprit.demo2.entites;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Bloc {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambres;
}
