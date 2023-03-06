package com.santiago.heroes.service;

import com.santiago.heroes.model.addheroe.AddHeroe_IN;
import com.santiago.heroes.model.deleteheroe.DeleteHeroe_IN;
import com.santiago.heroes.model.listheroesbyname.ListHeroesByName_IN;
import com.santiago.heroes.model.listheroesbyname.ListHeroesByName_OUT;
import com.santiago.heroes.model.modifyheroe.ModifyHeroe_IN;
import com.santiago.heroes.model.findheroe.FindHeroe_IN;
import com.santiago.heroes.model.findheroe.FindHeroe_OUT;
import com.santiago.heroes.model.listheroes.ListHeroes_OUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Transactional
@Service
public class HeroesService {

    @Autowired
    private HeroesCommands commands;

    public void addHeroe(AddHeroe_IN in) {
        commands.addHeroeCommands().execute(in);
    }

    public void deleteHeroe(DeleteHeroe_IN in) {
        commands.deleteHeroeCommands().execute(in);
    }

    public FindHeroe_OUT findHeroe(FindHeroe_IN in) {
        return commands.findHeroeCommands().execute(in);
    }

    public ListHeroes_OUT listHeroes() {
        return commands.listHeroesCommands().execute();
    }

    public void modifyHeroe(ModifyHeroe_IN in) {
        commands.modifyHeroesCommands().execute(in);
    }

    public ListHeroesByName_OUT listHeroesByName(ListHeroesByName_IN in) { return commands.listHeroesByNameCommands().execute(in); }
}
