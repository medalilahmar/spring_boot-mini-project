package tn.esprit.demo2.services;

import tn.esprit.demo2.entites.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation updateReservation(Reservation r);
    public Reservation retrieveReservation(Long idReservation);
}
