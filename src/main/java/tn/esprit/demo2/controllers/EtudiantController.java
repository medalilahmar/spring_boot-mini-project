package tn.esprit.demo2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo2.entites.Etudiant;
import tn.esprit.demo2.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    IEtudiantService etudiantService;

    @GetMapping("/get-all")
    public List<Etudiant> getAll(){
        return etudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/add-Etudiant")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants){
        return etudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/update-Etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant f){
        return etudiantService.updateEtudiant(f);
    }

    @GetMapping("/get-Etudiant/{id}")
    public Etudiant getEtudiant(@PathVariable("id") Long id){
        return etudiantService.retrieveEtudiant(id);
    }
    @DeleteMapping("/delete-Etudiant/{id}")
    public void removeEtudiant(@PathVariable("id") Long id){
        etudiantService.removeEtudiant(id);
    }


    @GetMapping("/ecole/{ecole}")
    public List<Etudiant> getEtudiantsByEcole(@PathVariable String ecole) {
        return etudiantService.getEtudiantsByEcole(ecole);
    }
}
