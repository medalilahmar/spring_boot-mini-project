package tn.esprit.demo2.entites;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
@Entity

public class Universite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;

    @OneToOne(mappedBy = "universite")
    private Foyer foyer;
}
