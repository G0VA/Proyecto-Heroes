package com.santiago.heroes.service.deleteheroe;

import com.santiago.heroes.model.deleteheroe.DeleteHeroe_IN;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteHeroeCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteHeroeCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;


    public void execute(DeleteHeroe_IN in) {
        LOGGER.info("INICIO DeleteHeroe");
        if (in.getId() == null) {
            LOGGER.error("ERROR -> El ID del heroe a eliminar no puede ser nulo");
            //throw new IllegalArgumentException("El ID del heroe a eliminar no puede ser nulo");
        }

        Optional<Heroe> heroe = heroeRepository.find(in.getId());
        if (heroe.isEmpty()){
            LOGGER.error("ERROR -> No existe Heroe con el ID: " + in.getId());
            //throw new NoSuchElementException("El Heroe a eliminar no existe");
        }

        LOGGER.info("Se borra el Heroe con ID: " + in.getId());
        heroeRepository.delete(heroe.get());
        LOGGER.info("Heroe borrado correctamente");

        LOGGER.info("FIN DeleteHeroe");
    }
}
