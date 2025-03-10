package tn.esprit.demo2.services;

import tn.esprit.demo2.entites.Chambre;
import tn.esprit.demo2.entites.TypeChambre;

import java.util.List;

public interface IChambreService {

    public List<Chambre> retrieveAllChambres();
    public Chambre addChambre(Chambre c);
    public Chambre updateChambre(Chambre c);
    public Chambre retrieveChambre(Long idChambre) ;

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
   public  List<Chambre> getChambresParBlocEtTypeKeyword(long idBloc, TypeChambre typeC);

}
