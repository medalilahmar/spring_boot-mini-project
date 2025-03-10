package tn.esprit.demo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo2.entites.Chambre;
import tn.esprit.demo2.entites.TypeChambre;
import tn.esprit.demo2.repositories.IChambreRepository;

import java.util.List;

@Service

public class ChambreService implements IChambreService{
    @Autowired
    IChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }


    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return chambreRepository.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.getChambresParBlocEtTypeJPQL(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeKeyword(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBloc_IdBlocAndTypeC(idBloc, typeC);
    }
}
