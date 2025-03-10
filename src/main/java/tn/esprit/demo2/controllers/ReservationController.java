package tn.esprit.demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo2.entites.Reservation;
import tn.esprit.demo2.services.IReservationService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    IReservationService reservationService;

    @GetMapping("/get-all")
    public List<Reservation> retrieveAllReservations(){
        return reservationService.retrieveAllReservations();
    }
    @PutMapping("/update-reservation")
    public Reservation updateReservation(Reservation res){
        return reservationService.updateReservation(res);
    }

    @GetMapping("/get-reservation/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long id){
        return reservationService.retrieveReservation(id);
    }

    @GetMapping("/parAnnee")
    public List<Reservation> getReservationsParAnnee(@RequestParam Date anneeUniversitaire,
                                                     @RequestParam String nomUniversite) {
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }
}
