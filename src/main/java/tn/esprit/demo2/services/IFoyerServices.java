package tn.esprit.demo2.services;

import tn.esprit.demo2.entites.Foyer;
import java.util.List;

public interface IFoyerServices {
   public Foyer addFoyer (Foyer f);
  public   List<Foyer> retrieveAllFoyers();
   public Foyer updateFoyer(Foyer f);

  public   Foyer retrieveFoyer (long idFoyer);
   public void removeFoyer (long idFoyer);


    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);




}
