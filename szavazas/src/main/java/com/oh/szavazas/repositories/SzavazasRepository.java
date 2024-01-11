package com.oh.szavazas.repositories;

import com.oh.szavazas.models.Szavazas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SzavazasRepository extends CrudRepository<Szavazas, Long> {
    Optional<Szavazas> findAllByIdopont(String idopont);
}