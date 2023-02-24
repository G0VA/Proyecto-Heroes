package com.santiago.heroes.service.findheroe;

import com.santiago.heroes.model.findheroe.FindHeroe_IN;
import com.santiago.heroes.model.findheroe.FindHeroe_OUT;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class FindHeroeCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindHeroeCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;

    public FindHeroe_OUT execute(FindHeroe_IN in) {
        LOGGER.info("INICIO FindHeroe");

        if (in.getId() == null) {
            LOGGER.error("ERROR -> El ID del heroe a buscar no puede ser nulo");
            throw new IllegalArgumentException("El ID del heroe a buscar no puede ser nulo");
        }

        LOGGER.info("Se busca el Heroe con ID: " + in.getId());
        Optional<Heroe> heroe = heroeRepository.find(in.getId());
        if (heroe.isEmpty()){
            LOGGER.error("ERROR -> No existe Heroe con el ID: " + in.getId());
            throw new NoSuchElementException("El Heroe no existe");
        }

        LOGGER.info("Encontrado el Heroe");
        FindHeroe_OUT findHeroeOut = new FindHeroe_OUT();
        findHeroeOut.setHeroe(heroe.get());

        LOGGER.info("FIN FindHeroe");
        return findHeroeOut;
    }
}
