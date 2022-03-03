package com.example.toy.common.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

}
