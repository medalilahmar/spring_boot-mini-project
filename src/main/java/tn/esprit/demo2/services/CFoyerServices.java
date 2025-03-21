package tn.esprit.demo2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo2.entites.Bloc;
import tn.esprit.demo2.entites.Foyer;
import tn.esprit.demo2.entites.Universite;
import tn.esprit.demo2.repositories.IBlocRepository;
import tn.esprit.demo2.repositories.IFoyerRepository;
import tn.esprit.demo2.repositories.IUniversiteRepository;

import java.util.List;

@Service

@RequiredArgsConstructor
public class CFoyerServices implements IFoyerServices {


    IFoyerRepository foyerRepository;


     IUniversiteRepository universiteRepository;
     IBlocRepository blocRepository;



    @Override
    public Foyer addFoyer(Foyer f)
     {
         return foyerRepository.save(f);
     }


    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>)foyerRepository.findAll();
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }



    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {

        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if (universite == null) return null;

        foyer.setUniversite(universite);
        Foyer savedFoyer = foyerRepository.save(foyer);

        if (foyer.getBloc() != null) {
            for (Bloc bloc : foyer.getBloc()) {
                bloc.setFoyer(savedFoyer);
                blocRepository.save(bloc);
            }
        }

        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);

        return savedFoyer;
    }



}
