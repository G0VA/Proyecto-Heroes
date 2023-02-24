package com.santiago.heroes.repository;

import com.santiago.heroes.repository.dto.Heroe;

import java.util.List;
import java.util.Optional;

public interface HeroeRepository {

    List<Heroe> getHeroes();

    void delete(Heroe heroe);

    void add(Heroe in);

    List<Heroe> getHeroesByText(String text);

    void modify(Heroe heroe);

    Optional<Heroe> find(Long id);

    boolean exists(String nombre);
}
