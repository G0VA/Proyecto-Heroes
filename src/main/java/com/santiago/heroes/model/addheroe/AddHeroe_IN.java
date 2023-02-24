package com.santiago.heroes.model.addheroe;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddHeroe_IN {

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 255)
    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String grupo;
}
