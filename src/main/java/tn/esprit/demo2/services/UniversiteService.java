package tn.esprit.demo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo2.entites.Foyer;
import tn.esprit.demo2.entites.Universite;
import tn.esprit.demo2.repositories.IUniversiteRepository;
import tn.esprit.demo2.repositories.IFoyerRepository;

import java.util.List;
import java.util.Optional;

@Service


public class UniversiteService implements IUniversiteService{

    @Autowired
    private  IUniversiteRepository universiteRepository;

    @Autowired
    private IFoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite UpdateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }


    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (foyer == null || universite == null) {
            return null;
        }

        foyer.setUniversite(universite);
        universite.setFoyer(foyer);

        return universiteRepository.save(universite);
    }


    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite == null || universite.getFoyer() == null) {
            return universite;
        }
        Foyer foyer = universite.getFoyer();

        foyer.setUniversite(null);
        universite.setFoyer(null);

        foyerRepository.save(foyer);
        return universiteRepository.save(universite);
    }



}
