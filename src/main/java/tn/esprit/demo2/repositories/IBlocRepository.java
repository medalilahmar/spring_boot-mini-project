package tn.esprit.demo2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo2.entites.Bloc;
@Repository

public interface IBlocRepository extends CrudRepository<Bloc, Long> {



}
