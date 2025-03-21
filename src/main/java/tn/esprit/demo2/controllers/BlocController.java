package tn.esprit.demo2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo2.entites.Bloc;
import tn.esprit.demo2.services.IBlocservice;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocController  {

    @Autowired
    IBlocservice blocService;

    @GetMapping("/get-all")
    public List<Bloc> getAll(){
        return blocService.retrieveBlocs();
    }

    @PostMapping("/add-Bloc")
    public Bloc addBlocs(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

    @PutMapping("/update-Bloc")
    public Bloc updateBloc(@RequestBody Bloc f){
        return blocService.updateBloc(f);
    }

    @GetMapping("/get-Bloc/{id}")
    public Bloc getBloc(@PathVariable("id") Long id){
        return blocService.retrieveBloc(id);
    }
    @DeleteMapping("/delete-Bloc/{id}")
    public void removeBloc(@PathVariable("id") Long id){
        blocService.removeBloc(id);
    }


    @PutMapping("/affecterChambres/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre,
                                      @PathVariable("idBloc") long idBloc) {
        return blocService.affecterChambresABloc(numChambre, idBloc);
    }



}