package com.santiago.heroes.model.addheroe;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddHeroe_IN {

    @NotBlank
    @Size(min = 0, max = 255)
    @Getter @Setter
    private String nombre;

    @NotBlank
    @Size(min = 0, max = 255)
    @Getter @Setter
    private String grupo;
}
