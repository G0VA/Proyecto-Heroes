package com.santiago.heroes.repository;

import com.santiago.heroes.repository.dto.Heroe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HeroeRepositoryExtensionImpl implements HeroeRepositoryExtension{

    @PersistenceContext
    private EntityManager entityManager;

    /*
        Metodo para buscar Heroes por patron en el nombre.
     */
    @Override
    public List<Heroe> getHeroesByPatron(String patron) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Heroe> cq = cb.createQuery(Heroe.class);
        Root<Heroe> heroe = cq.from(Heroe.class);

        cq.select(heroe);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.like(heroe.get("nombre"), "%" + patron.toUpperCase() + "%"));
        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Heroe> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    /*
        Metodo para buscar Heroes por nombre exacto.
     */
    @Override
    public Optional<Heroe> getHeroeByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Heroe> cq = cb.createQuery(Heroe.class);
        Root<Heroe> heroe = cq.from(Heroe.class);
        cq.select(heroe);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(heroe.get("nombre"), name.toUpperCase()));
        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Heroe> query = entityManager.createQuery(cq);

        return query.getResultList().stream().findFirst();
    }
}
