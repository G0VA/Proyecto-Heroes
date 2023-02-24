package com.santiago.heroes.model.deleteheroe;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DeleteHeroe_IN {

    @NotBlank
    @Getter @Setter
    private Long id;
}
