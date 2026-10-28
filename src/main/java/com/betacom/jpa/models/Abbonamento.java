package com.betacom.jpa.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="abbonamento_socio")
public class Abbonamento {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(
			name="data_abbonamento",
			nullable = false
			)
	private LocalDate dataAbbonamento;
	
	@Column(
			name="durata_abbonamento",
			nullable = false
			)
	private Integer durataAbbonamento;
	
	
	@ManyToOne
	@JoinColumn (
			name = "id_socio"			
			)
	private Socio socio;
	
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(
			name="abbonamento_attivita",
			joinColumns = @JoinColumn (name="abbonamento_id"),
			inverseJoinColumns = @JoinColumn (name="attivita_id")
			)
	List<Attivita> attivita;
}
