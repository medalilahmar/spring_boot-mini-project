package tn.esprit.demo2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demo2.entites.Chambre;
import tn.esprit.demo2.entites.TypeChambre;


import java.util.List;

@Repository

public interface IChambreRepository  extends CrudRepository<Chambre, Long> {



    @Query("SELECT c FROM Chambre c WHERE c.bloc.universite.nomUniversite = :nomUniversite AND c.typeC = :type AND c.idChambre NOT IN " +
            "(SELECT r.chambre.idChambre FROM Reservation r WHERE YEAR(r.anneeUniversitaire) = YEAR(CURRENT_DATE))")
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@Param("nomUniversite") String nomUniversite,
                                                                     @Param("type") TypeChambre type);



    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> getChambresParBlocEtTypeJPQL(@Param("idBloc") long idBloc,
                                               @Param("typeC") TypeChambre typeC);


    List<Chambre> findByBloc_IdBlocAndTypeC(long idBloc, TypeChambre typeC);


}
