package com.example.learnup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Premier {

    private String name;
    private String description;
    private String ageGroup;
    private Integer allSeats;
    private Integer availableSeats;
    private List<Ticket> tickets = new ArrayList<>();

    public Premier(String name, String description, String ageGroup, Integer allSeats) {
        this.name = name;
        this.description = description;
        this.ageGroup = ageGroup;
        this.allSeats = allSeats;
        this.availableSeats = allSeats;
    }

}
