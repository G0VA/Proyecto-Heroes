package com.santiago.heroes.model.findheroe;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class FindHeroe_IN {

    @NotNull(message = "El ID no puede ser nulo")
    @Getter @Setter
    private Long id;
}
