package com.santiago.heroes.repository;

import com.santiago.heroes.repository.dto.Heroe;

import java.util.List;

public interface HeroeRepository {

    List<Heroe> getHeroes();

    void delete(Heroe heroe);

    void add(Heroe in);

    List<Heroe> getHeroesByText(String text);

    void modify(Heroe heroe);

    Heroe find(Long id);
}
