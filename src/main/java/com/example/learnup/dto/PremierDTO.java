package com.example.learnup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PremierDTO {
    private String email;
    private String name;
    private String description;
    private String ageGroup;
    private Integer allSeats;
}
