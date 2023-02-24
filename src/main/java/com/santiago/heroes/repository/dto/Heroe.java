package com.santiago.heroes.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
@ToString
public class Heroe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nombre", unique=true, nullable=false)
    private String nombre;

    @Getter @Setter @Column(name = "grupo")
    private String grupo;
}
