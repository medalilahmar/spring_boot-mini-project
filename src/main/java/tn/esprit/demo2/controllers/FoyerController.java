package tn.esprit.demo2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo2.entites.Foyer;
import tn.esprit.demo2.services.IFoyerServices;


import java.util.List;

@RestController
@RequestMapping("/foyers")

public class FoyerController {

    @Autowired
    IFoyerServices foyerService;

    @GetMapping("/get-all")
    public List<Foyer> getAll(){
        return foyerService.retrieveAllFoyers();
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerService.addFoyer(f);
    }

    @PutMapping("/update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return foyerService.updateFoyer(f);
    }

    @GetMapping("/get-foyer/{id}")
    public Foyer getFoyer(@PathVariable("id") Long id){
        return foyerService.retrieveFoyer(id);
    }
    @DeleteMapping("/delete-foyer/{id}")
    public void removeFoyer(@PathVariable("id") Long id){
        foyerService.removeFoyer(id);
    }


    @PostMapping("/ajouterEtAffecter/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,
                                                   @PathVariable("idUniversite") long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }


}
