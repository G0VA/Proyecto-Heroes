package com.santiago.heroes.model.listheroes;

import com.santiago.heroes.repository.dto.Heroe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListHeroes_OUT {

    @Getter @Setter
    private List<Heroe> heroes;
}
