package tn.esprit.demo2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo2.entites.Universite;

import java.util.List;

@Repository

public interface IUniversiteRepository extends CrudRepository<Universite, Long> {

    Universite findByNomUniversite(String nomUniversite);


}
