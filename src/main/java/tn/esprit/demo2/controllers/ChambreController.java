package tn.esprit.demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo2.entites.Chambre;
import tn.esprit.demo2.services.IChambreService;

import java.util.List;
@RestController
@RequestMapping("/chambre")

public class ChambreController {

        @Autowired
        IChambreService chambreService;

        @GetMapping("/get-all")
        public List<Chambre> getAll() {
            return chambreService.retrieveAllChambres();
        }

        @PostMapping("/add-Chambre")
        public Chambre addChambres(@RequestBody Chambre chambre) {
            return chambreService.addChambre(chambre);
        }

        @PutMapping("/update-Chambre")
        public Chambre updateChambre(@RequestBody Chambre f) {
            return chambreService.updateChambre(f);
        }

        @GetMapping("/get-Chambre/{id}")
        public Chambre getChambre(@PathVariable("id") Long id) {
            return chambreService.retrieveChambre(id);
        }
    }
