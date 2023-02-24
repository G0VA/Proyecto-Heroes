package com.santiago.heroes.service.deleteheroe;

import com.santiago.heroes.model.deleteheroe.DeleteHeroe_IN;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteHeroeCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteHeroeCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;


    public void execute(DeleteHeroe_IN in) {
        LOGGER.info("INICIO DeleteHeroe");
        if (in.getId() == null) {
            LOGGER.info("ERROR, se debe indicar el ID del Heroe a borrar");
        }

        LOGGER.info("Se borra el Heroe con ID: " + in.getId());
        Heroe Heroe = heroeRepository.find(in.getId());
        heroeRepository.delete(Heroe);
        LOGGER.info("Heroe borrado correctamente");

        LOGGER.info("FIN DeleteHeroe");
    }
}
