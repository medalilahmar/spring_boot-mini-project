package tn.esprit.demo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo2.entites.*;
import tn.esprit.demo2.repositories.IBlocRepository;
import tn.esprit.demo2.repositories.IEtudiantRepository;
import tn.esprit.demo2.repositories.IReservationRepository;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
@Service
public class ReservationService implements IReservationService {

    @Autowired
    IReservationRepository reservationRepository;

     IBlocRepository blocRepository;
     IEtudiantRepository etudiantRepository;

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

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }



    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {

        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (etudiant == null || bloc == null) return null;

        for (Chambre chambre : bloc.getChambres()) {
            int capaciteMax = chambre.getTypeC() == TypeChambre.SIMPLE ? 1 :
                    chambre.getTypeC() == TypeChambre.DOUBLE ? 2 : 3;

            if (chambre.getReservations().size() < capaciteMax) {
                Reservation reservation = new Reservation();
                reservation.setAnneeUniversitaire(new Date());
                reservation.setEstValide(true);
                reservation.setChambre(chambre);
                reservation.setEtudiant(etudiant);

                String numReservation = chambre.getNumeroChambre()
                        + "-" + bloc.getNomBloc()
                        + "-" + Calendar.getInstance().get(Calendar.YEAR);

                return reservationRepository.save(reservation);
            }
        }

        return null;
    }

}
