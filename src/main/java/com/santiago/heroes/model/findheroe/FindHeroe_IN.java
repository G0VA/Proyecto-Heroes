package com.santiago.heroes.model.findheroe;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FindHeroe_IN {

    @NotBlank
    @Getter @Setter
    private Long id;
}
