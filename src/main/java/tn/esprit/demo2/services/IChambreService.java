package tn.esprit.demo2.services;

import tn.esprit.demo2.entites.Chambre;

import java.util.List;

public interface IChambreService {

    public List<Chambre> retrieveAllChambres();
    public Chambre addChambre(Chambre c);
    public Chambre updateChambre(Chambre c);
    public Chambre retrieveChambre(Long idChambre) ;

}
