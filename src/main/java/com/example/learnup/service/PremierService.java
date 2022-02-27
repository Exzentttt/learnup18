package com.example.learnup.service;

import com.example.learnup.model.Premier;
import com.example.learnup.model.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.IntStream;

@Slf4j
@Service
public class PremierService {

    public final Map<String, Premier> premierMap = new HashMap<>();

    public Premier getPremier(String name) throws Exception {
        Premier premier = premierMap.get(name);
        if (premier == null) {
            throw new Exception("Премьера не найдена");
        }
        return premier;
    }

    public void addPremier(String name, String description, String ageGroup, Integer availableSeats) {
        premierMap.put(name, new Premier(name, description, ageGroup, availableSeats));
    }

    public void deletePremier(String name) {
        premierMap.remove(name);
    }

    public void updatePremierInformation(String name, String description, String ageGroup) {
        premierMap.get(name).setDescription(description).setAgeGroup(ageGroup);
    }

    public void buyTickets(String email, String name, Integer numberTickets) throws Exception {
        Premier premier = getPremier(name);
        if ((premier.getAvailableSeats() - numberTickets) <= 0) {
            throw new RuntimeException("Невозможно купить билет, мест больше нет");
        }
        premier.setAvailableSeats(premier.getAvailableSeats() - numberTickets);
        IntStream.range(0, numberTickets).forEachOrdered(i -> premier.getTickets().add(new Ticket(UUID.randomUUID(), premier.getName())));
    }

    public void returnTickets(String name, Integer numberTickets) throws Exception {
        Premier premier = getPremier(name);
        if (numberTickets > premier.getTickets().size()) {
            throw new RuntimeException("Невозможно вернуть больше билетов, чем есть у пользователя");
        }
        premier.setAvailableSeats(premier.getAvailableSeats() + numberTickets);
        IntStream.range(0, numberTickets).forEachOrdered(i -> premier.getTickets().remove(i));
    }

    public void getAllPremiers(String name) {
        for (Premier premier: premierMap.values()) {
            if (name != null) {
                if (Objects.equals(premier.getName(), name)) {
                    allInfoPrintPremier(premier);
                }
            } else {
                allInfoPrintPremier(premier);
            }
        }
    }

    public void allInfoPrintPremier(Premier premier) {
        log.info(
                "Премьера: {}, Описание: {}, Возрастная категория: {}, Количество мест: {}, Количество доступных мест: {}, Билеты: {}",
                premier.getName(),
                premier.getDescription(),
                premier.getAgeGroup(),
                premier.getAllSeats(),
                premier.getAvailableSeats(),
                premier.getTickets()
        );
    }

}
