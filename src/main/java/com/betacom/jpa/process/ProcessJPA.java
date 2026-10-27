package com.betacom.jpa.process;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.betacom.jpa.dto.input.CertificatoReq;
import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.output.SocioDTO;
import com.betacom.jpa.services.interfaces.ICertificatoServices;
import com.betacom.jpa.services.interfaces.ISocioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class ProcessJPA {
	
//	private final ISocioServices socioS;
//	private final ICertificatoServices certifS;
//	
//	public void createSocio() {
//		
//		log.debug("Create Socio ...");
//		try {
//			socioS.create(SocioReq.builder()
//					.nome("Paolo")
//					.cognome("Verde")
//					.codiceFiscale("111111111")
//					.email("v@tin.it")
//					.build());
//			
//			socioS.create(SocioReq.builder()
//					.nome("Anna")
//					.cognome("Bianca")
//					.codiceFiscale("222222222")
//					.email("b@tin.it")
//					.build());
//
//			socioS.create(SocioReq.builder()
//					.nome("Giuseppe")
//					.cognome("Nero")
//					.codiceFiscale("33333333")
//					.email("n@tin.it")
//					.build());
//
//			
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//	}
//	
//public void createSocio1() {
//		
//		log.debug("Create Socio ...");
//		try {
//			socioS.create(SocioReq.builder()
//					.nome("Paolo")
//					.cognome("Verde")
//					.codiceFiscale("111111111")
//					.email("v@tin.it")
//					.build());
//			
//			
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//	}
//	
//	public void listSocio() {
//		try {
//			List<SocioDTO>  lS =  socioS.list();
//			lS.forEach(s -> log.debug(s.toString()));
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//		
//	}
//	
//	public void setCertificato() {
//		try {
//			certifS.updateCertificato(CertificatoReq.builder()
//					.dataCerticifato(LocalDate.parse("2026-09-15"))
//					.tipo(true)
//					.socioID(7)
//					.build());
//		} catch (Exception e) {
//			log.error("Errore in aggiornamento certificato {}", e.getMessage());
//		}
//	}
//
//	public void updatSocio() {
//		try {
//			socioS.update(SocioReq.builder()
//					.id(5)
//					.nome("Alice")
//					.codiceFiscale("33333333")
//					.build()
//					);
//		} catch (Exception e) {
//			log.error("Errore in aggiornamento socio {}", e.getMessage());
//		}
//			
//	}
//	
//	public void deleteSocio() {
//		try {
//			socioS.delete(7);
//		} catch (Exception e) {
//			log.error("Errore in delete socio {}", e.getMessage());
//		}
//			
//	}
	
}
