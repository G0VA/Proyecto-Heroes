package com.santiago.heroes.service;

import com.santiago.heroes.service.addheroe.AddHeroeCommands;
import com.santiago.heroes.service.deleteheroe.DeleteHeroeCommands;
import com.santiago.heroes.service.findheroe.FindHeroeCommands;
import com.santiago.heroes.service.listheroes.ListHeroesCommands;
import com.santiago.heroes.service.listheroesbyname.ListHeroesByNameCommands;
import com.santiago.heroes.service.modifyheroe.ModifyHeroesCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeroesCommands {

    @Autowired
    private AddHeroeCommands addHeroeCommands;

    @Autowired
    private DeleteHeroeCommands deleteHeroeCommands;

    @Autowired
    private FindHeroeCommands findHeroeCommands;

    @Autowired
    private ListHeroesCommands listHeroesCommands;

    @Autowired
    private ModifyHeroesCommands modifyHeroesCommands;

    @Autowired
    private ListHeroesByNameCommands listHeroesByNameCommands;

    public AddHeroeCommands addHeroeCommands() {
        return addHeroeCommands;
    }

    public DeleteHeroeCommands deleteHeroeCommands() {
        return deleteHeroeCommands;
    }

    public FindHeroeCommands findHeroeCommands() {
        return findHeroeCommands;
    }

    public ListHeroesCommands listHeroesCommands() {
        return listHeroesCommands;
    }

    public ModifyHeroesCommands modifyHeroesCommands() {
        return modifyHeroesCommands;
    }

    public ListHeroesByNameCommands listHeroesByNameCommands() {return listHeroesByNameCommands; }
}
