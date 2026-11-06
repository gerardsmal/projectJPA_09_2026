package com.betacom.jpa.socio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.MutuallyExclusiveConfigurationPropertiesException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.betacom.jpa.controllers.SocioController;
import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.dto.output.SocioDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SocioControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private SocioController socC;
	
	
	@Test
	@Order(1)
	public void createSocio() {
		SocioReq req = new SocioReq();
		req.setNome("Bruno");
		req.setCognome("Libadela");
		req.setCodiceFiscale("BL3333333");
		req.setEmail("bL@tin.it");
	
		try {
			ResponseEntity<ResponseDTO> resp = socC.create(req);
			assertEquals(HttpStatus.OK, resp.getStatusCode());
		} catch (Exception e) {
			new AssertionError("Error in create (controller):" + e.getMessage());	}
	}
	
	@Test
	@Order(2)
	public void getSocio() throws Exception{
		log.debug("getSocio");
		ResponseEntity<?> resp = socC.getById(1);
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		SocioDTO soc = (SocioDTO)resp.getBody();
		Assertions.assertThat(soc.getCognome()).isEqualTo("Verdi");
	}
	
	@Test
	@Order(3)
	public void getSocioError() throws Exception{
		log.debug("getSocioError");
		
		mockMvc.perform(get("/rest/socio/getById")
	            .param("id", "99"))
	        .andExpect(status().isBadRequest())
	        .andExpect(jsonPath("$.msg").exists()); // per verficare che il return contain il tag msg
		
	}
		
	
	
}
