package tn.esprit.demo2.entites;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Universite {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    public Long getIdUniversite() {
        return idUniversite;
    }

    public String getNomUniversite() {
        return nomUniversite;
    }

    public void setNomUniversite(String nomUniversite) {
        this.nomUniversite = nomUniversite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Foyer getFoyer() {
        return foyer;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public void setIdUniversite(Long idUniversite) {
        this.idUniversite = idUniversite;
    }

    private String nomUniversite;
    private String adresse;



    @OneToOne
    private Foyer foyer;

    public Long getId() { return idUniversite; }
    public void setId(Long id) { this.idUniversite = idUniversite; }

    public String getNom() { return nomUniversite; }
    public void setNom(String nomUniversite) { this.nomUniversite = nomUniversite; }


}
