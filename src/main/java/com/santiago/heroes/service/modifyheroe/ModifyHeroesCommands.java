package com.santiago.heroes.service.modifyheroe;

import com.santiago.heroes.model.modifyheroe.ModifyHeroe_IN;
import com.santiago.heroes.repository.HeroeRepository;
import com.santiago.heroes.repository.dto.Heroe;
import com.santiago.heroes.service.findheroe.FindHeroeCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

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
            LOGGER.error("ERROR -> El ID del heroe a modificar no puede ser nulo");
            throw new IllegalArgumentException("El ID del heroe a modificar no puede ser nulo");
        }

        if (in.getHeroe().getNombre() == null || in.getHeroe().getNombre().isEmpty()) {
            LOGGER.error("ERROR -> El NOMBRE del heroe a modificar no puede ser nulo o vacio");
            throw new IllegalArgumentException("El NOMBRE del heroe a modificar no puede ser nulo o vacio");
        }

        Optional<Heroe> heroe = heroeRepository.findById(in.getHeroe().getId());

        if (heroe.isEmpty()) {
            LOGGER.error("ERROR -> No existe Heroe con el ID: " + in.getHeroe().getId());
            throw new NoSuchElementException("El Heroe a modificar no existe");
        }
        Heroe heroeModify = heroe.get();
        heroeModify.setNombre(in.getHeroe().getNombre().toUpperCase());
        heroeModify.setGrupo(in.getHeroe().getGrupo().toUpperCase());
        LOGGER.info("Se modifica el Heroe con ID: " + in.getHeroe().getId());
        heroeRepository.save(heroeModify);
        LOGGER.info("Heroe modificado correctamente");
        LOGGER.info("FIN ModifyHeroe");
    }
}
