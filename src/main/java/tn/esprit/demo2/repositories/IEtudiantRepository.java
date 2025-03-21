package tn.esprit.demo2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demo2.entites.Etudiant;

import java.util.List;

@Repository

public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Query("SELECT e FROM Etudiant e WHERE e.ecole = :ecole")
    List<Etudiant> findByEcole(@Param("ecole") String ecole);



    Etudiant findByCin(Long cin);


}
