package tn.esprit.demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo2.entites.Universite;
import tn.esprit.demo2.services.IUniversiteService;

import java.util.List;

public class UniversiteController {

    @Autowired
    IUniversiteService universiteService;

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteService.addUniversite(u);
    }

    @GetMapping("/get-all")
    public List<Universite> retrieveAll(){
        return universiteService.retrieveAllUniversities();
    }

    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody  Universite u ){
        return universiteService.updateUniversite(u);
    }

    @GetMapping("/find-univeristy/{id}")
    public Universite retrieveUniversite(@PathVariable("id") Long id)
    {
        return universiteService.retrieveUniversite(id);
    }
}
