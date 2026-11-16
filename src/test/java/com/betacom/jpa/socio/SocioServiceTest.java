package com.betacom.jpa.socio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.output.SocioDTO;
import com.betacom.jpa.services.interfaces.ISocioServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SocioServiceTest {

	@Autowired
	private ISocioServices socioS;
	
	@Order(1)
	@Test
	public void createSocioTest() {
		log.debug("Create-list Socio");
		try {
			SocioReq req = new SocioReq();
			req.setNome("Paolo");
			req.setCognome("Verdi");
			req.setCodiceFiscale("PV111111");
			req.setEmail("pv@tin.it");
			
			socioS.create(req);
			List<SocioDTO> lS = socioS.list(null, null, null, null);
			SocioDTO socioCreated = lS.stream()
					.filter(s -> "PV111111".equals(s.getCodiceFiscale()))
					.findFirst()
					.orElseThrow(() -> new AssertionError("Socio non trovato"));
			
			Assertions.assertThat(socioCreated.getCognome()).isEqualTo("Verdi");
			
			
			req = new SocioReq();
			req.setNome("Mimmo");
			req.setCognome("Laverdura");
			req.setCodiceFiscale("ML2222222");
			req.setEmail("ml@tin.it");
			
			socioS.create(req);
			lS = socioS.list(null, null, null, null);
			socioCreated = lS.stream()
					.filter(s -> "ML2222222".equals(s.getCodiceFiscale()))
					.findFirst()
					.orElseThrow(() -> new AssertionError("Socio non trovato"));
			Assertions.assertThat(socioCreated.getCognome()).isEqualTo("Laverdura");
			
		} catch (Exception e) {
			new AssertionError("Error in create:" + e.getMessage());
		}
	}
	
	@Order(2)
	@Test
	public void createSocioError() {
		log.debug("createSocioError");
		
		SocioReq req = new SocioReq();
		req.setNome("Paolo");
		req.setCognome("Verdi");
		req.setCodiceFiscale("PV111111");
		req.setEmail("pv@tin.it");
		
		assertThrows(Exception.class, () -> socioS.create(req));
	
		
		
	}
}
