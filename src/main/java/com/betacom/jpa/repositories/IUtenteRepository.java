package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.Utente;

public interface IUtenteRepository extends JpaRepository<Utente, String>{

}
