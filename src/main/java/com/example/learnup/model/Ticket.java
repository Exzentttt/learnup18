package com.example.learnup.model;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Premier premier;

    public Ticket(Premier premier) {
        this.premier = premier;
    }

}
