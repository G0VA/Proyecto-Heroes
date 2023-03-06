package com.santiago.heroes.model.listheroesbyname;

import com.santiago.heroes.repository.dto.Heroe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ListHeroesByName_OUT {


    @Getter @Setter
    private List<Heroe> heroes;
}
