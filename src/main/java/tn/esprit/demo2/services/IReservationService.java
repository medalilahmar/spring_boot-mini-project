package tn.esprit.demo2.services;

import tn.esprit.demo2.entites.Reservation;

import java.sql.Date;
import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation updateReservation(Reservation r);
    public Reservation retrieveReservation(Long idReservation);

    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);

}
