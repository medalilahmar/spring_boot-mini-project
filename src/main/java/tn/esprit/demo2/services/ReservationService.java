package tn.esprit.demo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo2.entites.Reservation;
import tn.esprit.demo2.repositories.IReservationRepository;

import java.util.List;
@Service
public class ReservationService implements IReservationService {

    @Autowired
    IReservationRepository reservationRepository;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
}
