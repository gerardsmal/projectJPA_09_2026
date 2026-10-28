package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Attivita;

@Repository
public interface IAttivitaRepository extends JpaRepository<Attivita, Integer>{
	Boolean existsByDescrizione(String descrizione);
}
