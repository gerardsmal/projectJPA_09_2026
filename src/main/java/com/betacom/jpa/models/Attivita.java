package com.betacom.jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="attivita_palestra")
public class Attivita {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(
			name="descrizione_attivita",
			length = 100,
			nullable = false
			)
	private String descrizione;
	
	@Column(
			name="prezzo_attivita",
			nullable = false			
			)
	private Long prezzo;
	
	@ManyToMany(
			mappedBy = "attivita",
			fetch = FetchType.LAZY			
			)
	List<Abbonamento> abbonamento;
}
