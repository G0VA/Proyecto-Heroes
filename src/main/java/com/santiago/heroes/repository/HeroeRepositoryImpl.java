package com.santiago.heroes.repository;

import com.santiago.heroes.repository.dto.Heroe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class HeroeRepositoryImpl implements HeroeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Heroe> getHeroes() {
        String query = "FROM Heroe";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Heroe heroe) {
        entityManager.remove(heroe);
    }

    @Override
    public void add(Heroe heroe) {
        entityManager.merge(heroe);
    }

    @Override
    public List<Heroe> getHeroesByText(String text) {
        String query = "FROM Heroe WHERE UPPER(NOMBRE) = :nombre";
        return entityManager.createQuery(query)
                .setParameter("nombre", "%"+text.toUpperCase()+"%")
                .getResultList();
    }

    @Override
    public void modify(Heroe heroe) {
        entityManager.merge(heroe);
    }

    @Override
    public Heroe find(Long id) {
        return entityManager.find(Heroe.class, id);
    }
}
