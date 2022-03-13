package com.example.learnup.dto;

import com.example.learnup.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PremierDTO {
    private UUID requestId;
    private String name;
    private String description;
    private String ageGroup;
    private Integer allSeats;
}
