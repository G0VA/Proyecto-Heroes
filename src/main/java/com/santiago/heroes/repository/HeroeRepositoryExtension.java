package com.santiago.heroes.repository;

import com.santiago.heroes.repository.dto.Heroe;

import java.util.List;
import java.util.Optional;

public interface HeroeRepositoryExtension {
    List<Heroe> getHeroesByPatron(String patron);

    Optional<Heroe> getHeroeByName(String name);
}
