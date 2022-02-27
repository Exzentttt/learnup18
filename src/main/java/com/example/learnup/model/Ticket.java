package com.example.learnup.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;


@Data
@AllArgsConstructor
public class Ticket {
    private UUID name;
    private String premierName;
}
