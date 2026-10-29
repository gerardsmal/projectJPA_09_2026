package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.betacom.jpa.models.Socio;

public interface ISocioRepository extends JpaRepository<Socio, Integer>{
	Boolean existsByCodiceFiscale(String codiceFiscale);
	
	List<Socio> findByCognomeStartingWith(String cognome);
	
	@Query(name="socio.cognome.like")
	List<Socio> searchByCognome(@Param("cognome") String cognome);
	
	@Query (name="socio.selectByAttivita")
	List<Socio> selectByAttivita(@Param("id") Integer id);
	
	@Query (name ="socio.selectByFilter")
	List<Socio> searchByFilter(
			@Param("id") Integer id,
			@Param("nome") String nome,
			@Param("cognome") String cognome,
			@Param("attivita") Integer attivita
			);
}
