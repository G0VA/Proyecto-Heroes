package com.santiago.heroes.service.listheroes;

import com.santiago.heroes.model.listheroes.ListHeroes_OUT;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Component
public class ListHeroesCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListHeroesCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;

    public ListHeroes_OUT execute() {
        StopWatch sw = new StopWatch();
        sw.start();
        LOGGER.info("INICIO ListHeroes");
        ListHeroes_OUT listHeroesOut = new ListHeroes_OUT();

        LOGGER.info("Se recuperan Heroes");
        List<Heroe> listHeroes = heroeRepository.findAll();

        if (listHeroes.isEmpty()) {
            LOGGER.info("No se recuperaron Heroes, la BBDD esta vacia");
        }

        listHeroesOut.setHeroes(listHeroes);
        LOGGER.info("FIN ListHeroes");
        sw.stop();
        LOGGER.info("Ejecucion -> " + sw.prettyPrint().substring(sw.prettyPrint().indexOf("=")+1,sw.prettyPrint().indexOf("ns")));
        return listHeroesOut;
    }
}
