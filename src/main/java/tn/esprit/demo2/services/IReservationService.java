package tn.esprit.demo2.services;

import tn.esprit.demo2.entites.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
     Reservation updateReservation(Reservation r);
     Reservation retrieveReservation(Long idReservation);

     List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(java.util.Date anneeUniversitaire, String nomUniversite);


    Reservation ajouterReservation(long idBloc, long cinEtudiant);

}
