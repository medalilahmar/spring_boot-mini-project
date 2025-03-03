package tn.esprit.demo2.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo2.entites.Foyer;
import tn.esprit.demo2.repositories.IFoyerRepository;

import java.util.List;

@Service

@RequiredArgsConstructor
@AllArgsConstructor
public class CFoyerServices implements IFoyerServices {

     IFoyerRepository foyerRepository;



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



}
