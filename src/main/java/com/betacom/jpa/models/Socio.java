package com.betacom.jpa.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="socio_palestra")
public class Socio {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(
			length=100,
			nullable = false
			)
	private String cognome;
	
	
	@Column(
			length=100,
			nullable = false
			)
	private String nome;
	
	
	@Column(
			name="codice_fiscale",
			length=16,
			nullable = false,
			unique=true
			)
	private String codiceFiscale;;
	private String email;
	
	@OneToOne(
			cascade = CascadeType.REMOVE,
			orphanRemoval = true
			)
	@JoinColumn(
			name="certificato_id",
			referencedColumnName = "id"
			)	
	private Certificato certificato;

}
