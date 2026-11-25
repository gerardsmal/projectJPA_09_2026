package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.Personne;

public interface IPersoneRepository extends JpaRepository<Personne, Integer>{

}
