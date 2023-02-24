package com.santiago.heroes.service.listheroes;

import com.santiago.heroes.model.listheroes.ListHeroes_IN;
import com.santiago.heroes.model.listheroes.ListHeroes_OUT;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListHeroesCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListHeroesCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;

    public ListHeroes_OUT execute(ListHeroes_IN in) {
        StopWatch sw = new StopWatch();
        sw.start();
        LOGGER.info("INICIO ListHeroes");
        ListHeroes_OUT listHeroesOut = new ListHeroes_OUT();

        LOGGER.info("Se recuperan Heroes");
        List<Heroe> listHeroes = heroeRepository.getHeroes();

        if (listHeroes.isEmpty()) {
            LOGGER.info("No se recuperaron Heroes, la BBDD esta vacia");
            listHeroesOut.setHeroes(listHeroes);
        } else {
            if (in.getText() == null || in.getText().isEmpty()) {
                LOGGER.info("Al no especificar texto de busqueda se recuperaran todos los heroes");
                listHeroesOut.setHeroes(listHeroes);
                listHeroes.stream().forEach(heroe -> LOGGER.debug(heroe.toString()));
            } else {
                LOGGER.info("Al especificar texto de busqueda se recuperaran los heroes que contengan el texto: " + in.getText());
                List<Heroe> listHeroesFiltrada = listHeroes.stream()
                        .filter(heroe -> heroe.getNombre().toUpperCase().contains(in.getText().toUpperCase()))
                        .collect(Collectors.toList());
                listHeroesOut.setHeroes(listHeroesFiltrada);
                listHeroesFiltrada.stream().forEach(heroe -> LOGGER.debug(heroe.toString()));
            }
        }

        LOGGER.info("FIN ListHeroes");
        sw.stop();
        LOGGER.info("Ejecucion -> " + sw.prettyPrint().substring(sw.prettyPrint().indexOf("=")+1,sw.prettyPrint().indexOf("ns")));
        return listHeroesOut;
    }
}
