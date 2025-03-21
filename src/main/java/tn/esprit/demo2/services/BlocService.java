package tn.esprit.demo2.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo2.entites.Bloc;
import tn.esprit.demo2.entites.Chambre;
import tn.esprit.demo2.repositories.IBlocRepository;
import tn.esprit.demo2.repositories.IChambreRepository;

import java.util.List;
@Service
@RequiredArgsConstructor

public class BlocService  implements IBlocservice{



    IBlocRepository blocRepository;

    IChambreRepository chambreRepository;


    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }



    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if(bloc == null) return null;

        List<Chambre> chambres = chambreRepository.findAllById(numChambre);

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }

        chambreRepository.saveAll(chambres);
        return blocRepository.save(bloc);
    }

}
