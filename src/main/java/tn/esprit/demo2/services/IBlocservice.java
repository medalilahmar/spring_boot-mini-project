package tn.esprit.demo2.services;


import tn.esprit.demo2.entites.Bloc;

import java.util.List;

public interface IBlocservice {

    List<Bloc> retrieveBlocs();
    Bloc updateBloc(Bloc bloc);
    Bloc addBloc(Bloc bloc);
    Bloc retrieveBloc(Long idBloc);
    void removeBloc(Long idBloc);
}
