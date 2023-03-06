package com.santiago.heroes.service.addheroe;

import com.santiago.heroes.model.addheroe.AddHeroe_IN;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddHeroeCommands {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddHeroeCommands.class);

    @Autowired
    private HeroeRepository heroeRepository;

    public void execute(AddHeroe_IN in) {
        LOGGER.info("INICIO AddHeroe");

        if (in.getNombre() == null || in.getNombre().isEmpty()) {
            LOGGER.error("ERROR -> El nombre no puede ser nulo o vacio");
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }

        Optional<Heroe> opHeroe = heroeRepository.getHeroeByName(in.getNombre());
        if (opHeroe.isPresent()) {
            LOGGER.error("ERROR -> El Heroe " + in.getNombre().toUpperCase() + " ya existe");
            throw new DuplicateKeyException("El Heroe ya existe");
        }
        Heroe heroe = new Heroe();
        heroe.setGrupo(in.getGrupo().toUpperCase());
        heroe.setNombre(in.getNombre().toUpperCase());

        LOGGER.info("Se va a insertar el heroe: " + in.getNombre());
        heroeRepository.save(heroe);
        LOGGER.info("Insertado heroe correctamente");

        LOGGER.info("FIN AddHeroe");
    }
}
