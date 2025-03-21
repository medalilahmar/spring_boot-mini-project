package tn.esprit.demo2.services;

import tn.esprit.demo2.entites.Universite;

import java.util.List;
import java.util.Optional;

public interface IUniversiteService {

    public List<Universite> retrieveAllUniversities();
    public Universite addUniversite(Universite u);
    public Universite UpdateUniversite(Universite u);
    public Universite retrieveUniversite(Long idUniversite);

    public Universite updateUniversite(Universite u);

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);


    public Universite desaffecterFoyerAUniversite(long idUniversite);

}
