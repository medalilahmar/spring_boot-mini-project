package tn.esprit.demo2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demo2.entites.Reservation;





import java.sql.Date;
import java.util.List;

@Repository

public interface IReservationRepository extends CrudRepository<Reservation, Long> {


    @Query("SELECT r FROM Reservation r WHERE YEAR(r.anneeUniversitaire) = YEAR(:anneeUniversitaire) " +
            "AND r.chambre.bloc.universite.nomUniversite = :nomUniversite")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@Param("anneeUniversitaire") Date anneeUniversitaire,
                                                                         @Param("nomUniversite") String nomUniversite);
}
