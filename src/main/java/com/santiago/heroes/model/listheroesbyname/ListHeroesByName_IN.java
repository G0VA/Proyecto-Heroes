package com.santiago.heroes.model.listheroesbyname;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class ListHeroesByName_IN {

    @NotNull(message = "El PATRON no puede ser nulo")
    @Getter @Setter
    private String patron;
}
