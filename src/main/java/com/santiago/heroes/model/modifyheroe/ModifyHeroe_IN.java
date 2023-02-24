package com.santiago.heroes.model.modifyheroe;

import com.santiago.heroes.repository.dto.Heroe;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ModifyHeroe_IN {

    @NotBlank
    @Getter @Setter
    private Heroe heroe;
}
