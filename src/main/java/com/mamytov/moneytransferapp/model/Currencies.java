package com.mamytov.moneytransferapp.model;


import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "currencies")
@Data
public class Currencies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 3)
    private String name;

    @OneToMany(mappedBy = "currency")
    private List<Transaction> transaction;

}
