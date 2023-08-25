package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Titolo;

public interface TitoloStudioRepository extends JpaRepository<Titolo, Integer> {

}
