package com.santiago.heroes.repository.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "heroes")
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Heroe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @NotNull
    @Column(name = "nombre", unique=true, nullable=false)
    private String nombre;

    @Getter @Setter @Column(name = "grupo")
    private String grupo;
}
