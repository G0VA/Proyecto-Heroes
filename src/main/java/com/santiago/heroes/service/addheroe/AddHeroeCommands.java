package com.santiago.heroes.service.addheroe;

import com.santiago.heroes.model.addheroe.AddHeroe_IN;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddHeroeCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddHeroeCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;

    public void execute(AddHeroe_IN in) {
        LOGGER.info("INICIO AddHeroe");

        Heroe heroe = new Heroe();
        heroe.setGrupo(in.getGrupo());
        heroe.setNombre(in.getNombre());

        LOGGER.info("Se va a insertar el heroe: " + in.getNombre());
        heroeRepository.add(heroe);
        LOGGER.info("Insertado heroe correctamente");

        LOGGER.info("FIN AddHeroe");
    }
}