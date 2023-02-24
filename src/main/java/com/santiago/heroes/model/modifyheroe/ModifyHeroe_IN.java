package com.santiago.heroes.model.modifyheroe;

import com.santiago.heroes.repository.dto.Heroe;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class ModifyHeroe_IN {

    @NotNull(message = "El ID no puede ser nulo")
    @Getter @Setter
    private Heroe heroe;
}
