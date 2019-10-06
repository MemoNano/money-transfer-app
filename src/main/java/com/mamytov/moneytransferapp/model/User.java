package com.mamytov.moneytransferapp.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;


    @Column(length = 50, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 50, nullable = false, name = "last_name")
    private String lastName;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Transaction> transactions;


}
