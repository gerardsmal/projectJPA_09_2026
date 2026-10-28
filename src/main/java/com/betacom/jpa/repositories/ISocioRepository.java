package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Socio;

@Repository
public interface ISocioRepository extends JpaRepository<Socio, Integer>{
	Boolean existsByCodiceFiscale(String codiceFiscale);
	
	
	@Query(name="socio.cognome.like")
	List<Socio> searchByCognome(@Param("cognome") String cognome);
	
	@Query (name="socio.selectByAttivita")
	List<Socio> selectByAttivita(@Param("id") Integer id);
}
