package com.santiago.heroes.service.listheroesbyname;

import com.santiago.heroes.model.listheroesbyname.ListHeroesByName_IN;
import com.santiago.heroes.model.listheroesbyname.ListHeroesByName_OUT;

import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListHeroesByNameCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListHeroesByNameCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;

    public ListHeroesByName_OUT execute (ListHeroesByName_IN in) {
        LOGGER.info("INICIO ListHeroesByPatron");
        if (in.getPatron() == null || in.getPatron().isEmpty()) {
            LOGGER.error("ERROR -> El PATRON a buscar en el nombre de los heroes no puede ser nulo o vacio");
            throw new IllegalArgumentException("ERROR -> El PATRON a buscar en el nombre de los heroes no puede ser nulo o vacio");
        }

        LOGGER.info("Se recuperan Heroes con el patron :" + in.getPatron());
        List<Heroe> listHeroes = getHeroesCache(in.getPatron());

        if (listHeroes.isEmpty()) {
            LOGGER.info("No se recuperaron Heroes con el patron " + in.getPatron());
        }

        ListHeroesByName_OUT out = new ListHeroesByName_OUT();
        out.setHeroes(listHeroes);
        LOGGER.info("FIN ListHeroesByPatron");
        return out;
    }

    @Cacheable("heroes")
    private List<Heroe> getHeroesCache(String patron) {
        return heroeRepository.getHeroesByPatron(patron);
    }
}
