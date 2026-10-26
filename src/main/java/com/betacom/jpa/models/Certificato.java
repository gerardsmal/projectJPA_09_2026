package com.betacom.jpa.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="certificato medico")
public class Certificato {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name="tipo_certificato")
	private Boolean tipo;  // false normale true agonistico

	@Column (name="data_certificato")
	private LocalDate dataCerticifato;
	
	@OneToOne (mappedBy = "certificato")
	private Socio socio;
}
