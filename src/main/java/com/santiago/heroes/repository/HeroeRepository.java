package com.santiago.heroes.repository;

import com.santiago.heroes.repository.dto.Heroe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroeRepository extends JpaRepository<Heroe, Long>, HeroeRepositoryExtension {
}
