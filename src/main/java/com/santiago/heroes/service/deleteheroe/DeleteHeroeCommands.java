package com.santiago.heroes.service.deleteheroe;

import com.santiago.heroes.model.deleteheroe.DeleteHeroe_IN;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class DeleteHeroeCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteHeroeCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;


    public void execute(DeleteHeroe_IN in) {
        LOGGER.info("INICIO DeleteHeroe");
        if (in.getNombre() == null  || in.getNombre().isEmpty()) {
            LOGGER.error("ERROR -> El NOMBRE del heroe a eliminar no puede ser nulo o vacio");
            throw new IllegalArgumentException("El NOMBRE del heroe a eliminar no puede ser nulo o vacio");
        }

        Optional<Heroe> opHeroe = heroeRepository.getHeroeByName(in.getNombre());
        if (opHeroe.isEmpty()) {
            LOGGER.error("ERROR -> El Heroe " + in.getNombre().toUpperCase() + " no existe");
            throw new NoSuchElementException("El Heroe no existe");
        }

        LOGGER.info("Se borra el Heroe : " + in.getNombre());
        heroeRepository.delete(opHeroe.get());
        LOGGER.info("Heroe borrado correctamente");

        LOGGER.info("FIN DeleteHeroe");
    }
}
