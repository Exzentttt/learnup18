package com.example.learnup.service;

import com.example.learnup.model.Premier;
import com.example.learnup.model.Ticket;
import com.example.learnup.repository.PremierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class PremierService {

    private final PremierRepository premierRepository;

    public void addPremier(String name, String description, String ageGroup, Integer allSeats) {
        Premier premier = new Premier();
        premier.setName(name);
        premier.setDescription(description);
        premier.setAgeGroup(ageGroup);
        premier.setAvailableSeats(allSeats);
        premier.setAllSeats(allSeats);
        premierRepository.save(premier);
    }

    public void deletePremier(String name) {
        premierRepository.deleteById(name);
    }

    @Transactional
    public void updatePremierInformation(String name, String description, String ageGroup) {
        premierRepository.updatePremier(name, description, ageGroup);
    }

    @Transactional
    public void buyTickets(String email, String name, Integer numberTickets) {
        premierRepository.findById(name).map(premier -> {
            if ((premier.getAvailableSeats() - numberTickets) <= 0) {
                throw new RuntimeException("Невозможно купить билет, мест больше нет");
            }
            premier.setAvailableSeats(premier.getAvailableSeats() - numberTickets);
            IntStream.range(0, numberTickets).forEachOrdered(i -> premier.getTickets().add(new Ticket(premier)));
            return premierRepository.save(premier);
        });
    }

    @Transactional
    public void returnTickets(String name, Integer numberTickets) {
        premierRepository.findById(name)
                .map(premier -> {
                    if (numberTickets > premier.getTickets().size()) {
                        throw new RuntimeException("Невозможно вернуть больше билетов, чем есть у пользователя");
                    }
                    premier.setAvailableSeats(premier.getAvailableSeats() + numberTickets);
                    IntStream.range(0, numberTickets).forEachOrdered(i -> premier.getTickets().remove(i));
                    return premierRepository.save(premier);
                });
    }

    public void getAllPremiers(String name) {
        for (Premier premier: premierRepository.findAll()) {
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
