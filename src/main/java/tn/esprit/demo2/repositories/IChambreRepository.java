package tn.esprit.demo2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo2.entites.Chambre;

@Repository

public interface IChambreRepository  extends CrudRepository<Chambre, Long> {
}
