package com.example.learnup.controllers;

import com.example.learnup.dto.PremierDTO;
import com.example.learnup.service.PremierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api", produces = "application/json")
public class PremiersController {

    private final PremierService premierService;

    @PostMapping("/premier")
    public void addPremier(@RequestBody PremierDTO premier) {
        premierService.addPremier(
                premier.getName(),
                premier.getDescription(),
                premier.getAgeGroup(),
                premier.getAllSeats()
        );
    }

    @DeleteMapping("/premier")
    public void deletePremier(@RequestParam("name") String name) {
        premierService.deletePremier(name);
    }

    @PutMapping("/premier")
    public void deletePremier(@RequestBody PremierDTO premier) {
        premierService.updatePremierInformation(
                premier.getName(),
                premier.getDescription(),
                premier.getAgeGroup()
        );
    }

    @PostMapping("/premier/buy")
    public void buyTickets(@RequestBody PremierDTO premier) {
        premierService.updatePremierInformation(
                premier.getName(),
                premier.getDescription(),
                premier.getAgeGroup()
        );
    }

    @PostMapping("/premier/return")
    public void returnTickets(@RequestParam("name") String name, @RequestParam("numberTickets") Integer numberTickets) {
        premierService.returnTickets(name, numberTickets);
    }

    @GetMapping("/premier")
    public void getAllPremiers(@RequestParam(value = "name", required = false) String name) {
        premierService.getAllPremiers(name);
    }

}
