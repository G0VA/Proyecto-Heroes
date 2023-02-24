package com.santiago.heroes.service.modifyheroe;

import com.santiago.heroes.model.modifyheroe.ModifyHeroe_IN;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import com.santiago.heroes.service.findheroe.FindHeroeCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModifyHeroesCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyHeroesCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;

    @Autowired
    private FindHeroeCommands findHeroeCommands;

    public void execute(ModifyHeroe_IN in) {
        LOGGER.info("INICIO ModifyHeroe");
        if (in.getHeroe() == null || in.getHeroe().getId() == null) {
            LOGGER.info("ERROR, se debe indicar el ID Heroe a modificar");
        }

        LOGGER.info("Se modifica el Heroe con ID: " + in.getHeroe().getId());
        Heroe heroe = heroeRepository.find(in.getHeroe().getId());
        heroe.setNombre(in.getHeroe().getNombre());
        heroe.setGrupo(in.getHeroe().getGrupo());
        heroeRepository.modify(heroe);
        LOGGER.info("Heroe modificado correctamente");

        LOGGER.info("FIN ModifyHeroe");

    }
}
