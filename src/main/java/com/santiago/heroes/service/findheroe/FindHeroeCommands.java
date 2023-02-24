package com.santiago.heroes.service.findheroe;

import com.santiago.heroes.model.findheroe.FindHeroe_IN;
import com.santiago.heroes.model.findheroe.FindHeroe_OUT;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindHeroeCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindHeroeCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;

    public FindHeroe_OUT execute(FindHeroe_IN in) {
        LOGGER.info("INICIO FindHeroe");

        if (in.getId() == null) {
            LOGGER.info("ERROR, se debe indicar el ID del Heroe a buscar");
            return new FindHeroe_OUT();
        }
        LOGGER.info("Se busca el Heroe con ID: " + in.getId());
        Heroe heroe = heroeRepository.find(in.getId());
        LOGGER.info("Encontrado el Heroe");

        FindHeroe_OUT findHeroeOut = new FindHeroe_OUT();
        findHeroeOut.setHeroe(heroe);

        LOGGER.info("FIN FindHeroe");
        return findHeroeOut;
    }
}
