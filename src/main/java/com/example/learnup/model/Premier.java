package com.example.learnup.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "premier")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Premier {

    @Id
    @Column(name = "id")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "age_group")
    private String ageGroup;

    @Column(name = "all_seats")
    private Integer allSeats;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @OneToMany(mappedBy = "premier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

}
