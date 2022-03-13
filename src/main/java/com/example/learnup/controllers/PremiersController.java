package com.example.learnup.controllers;

import com.example.learnup.dto.PremierDTO;
import com.example.learnup.service.PremierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "api", produces = "application/json")
public class PremiersController {

    private final PremierService premierService;

    @Secured("ROLE_ADMIN")
    @PostMapping("/premier")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addPremier(@RequestBody PremierDTO premier) {
        premierService.addPremier(
                premier.getName(),
                premier.getDescription(),
                premier.getAgeGroup(),
                premier.getAllSeats()
        );
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/premier")
    @ResponseStatus(code = HttpStatus.OK)
    public void deletePremier(@RequestParam("name") String name) {
        premierService.deletePremier(name);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/premier")
    @ResponseStatus(code = HttpStatus.OK)
    public void updatePremier(@RequestBody PremierDTO premier) {
        premierService.updatePremierInformation(
                premier.getName(),
                premier.getDescription(),
                premier.getAgeGroup()
        );
    }

    @Secured("ROLE_USER")
    @PostMapping("/premier/buy")
    @ResponseStatus(code = HttpStatus.OK)
    public void buyTickets(
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestParam("numberTickets") Integer numberTickets
    ) {
        premierService.buyTickets(email, name, numberTickets);
    }

    @Secured("ROLE_USER")
    @PostMapping("/premier/return")
    @ResponseStatus(code = HttpStatus.OK)
    public void returnTickets(@RequestParam("name") String name, @RequestParam("numberTickets") Integer numberTickets) {
        premierService.returnTickets(name, numberTickets);
    }

    @GetMapping("/premier")
    @ResponseBody
    public String getAllPremiers(@RequestParam(value = "name", required = false) String name) {
        return premierService.getAllPremiers(name);
    }

}
