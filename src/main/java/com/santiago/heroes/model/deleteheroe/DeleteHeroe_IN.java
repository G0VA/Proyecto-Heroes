package com.santiago.heroes.model.deleteheroe;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class DeleteHeroe_IN {

    @NotNull(message = "El NOMBRE no puede ser nulo")
    @Getter @Setter
    private String nombre;
}
