package com.mexpeditions.microserviceexpedition.controller;


import com.mexpeditions.microserviceexpedition.dao.ExpeditionDao;
import com.mexpeditions.microserviceexpedition.model.Expedition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    private ExpeditionDao expeditionDao;



    // listes des expeditions

    @GetMapping(value = "/expeditions")
    public List<Expedition> listeDesExpeditions() {
        List<Expedition> expeditions = expeditionDao.findAll();
        return expeditions;
    }


    //ajouter une expedition
    @PostMapping(value = "/Expeditions")
    public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition expedition) {
        Expedition expeditionAdded = expeditionDao.save(expedition);

        return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);
        }

//Récupérer une nouvelle expedition  par son Id

   @GetMapping(value = "/Expeditions/{id}")

    public Optional<Expedition> etatExpedition(@PathVariable int id) {

        Optional<Expedition> expedition = expeditionDao.findById(id);
        return expedition;
    }

     // Upadate une expedition
    @PutMapping (value = "/Expeditions")
    public void updateExpedition(@RequestBody Expedition expedition) {

        expeditionDao.save(expedition);
    }

}

