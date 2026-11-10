package com.betacom.jpa.socio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.betacom.jpa.controllers.SocioController;
import com.betacom.jpa.dto.input.SocioReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.dto.output.SocioDTO;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SocioControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private SocioController socC;
	
	@Autowired
	private ObjectMapper objectMapper;
	
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
		
	@Test
	@Order(4)
	public void createSocioRest() throws Exception {
		log.debug("createSocioRest");
		
		SocioReq req = new SocioReq();
		req.setNome("Antonio");
		req.setCognome("Dellalibera");
		req.setCodiceFiscale("DLA34844948");
		req.setEmail("ad@tin.it");
		
		mockMvc.perform(post("/rest/socio/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
			
	}	
	
	@Test
	@Order(5)
	public void updateSocioRest() throws Exception{
		log.debug("updateSocioRest");
		SocioReq req = new SocioReq();
		req.setId(4);
		req.setCognome("Blufardi");
		
		mockMvc.perform(patch("/rest/socio/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}

	@Test
	@Order(6)
	public void updateSocioErrorRest() throws Exception{
		log.debug("updateSocioRest");
		SocioReq req = new SocioReq();
		req.setCognome("Blufardi");
		
		MvcResult result =   mockMvc.perform(patch("/rest/socio/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)    
		.andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.msg").exists())
        .andReturn();
		
		String msg = JsonPath.read(
				result.getResponse().getContentAsString(),
				"$.msg");
		log.debug("error {}", msg);
		
	}

	
	@Test
	@Order(7)
	public void ListRest() throws Exception{
		log.debug("ListRest");
		
		MvcResult result = mockMvc.perform(get("/rest/socio/list")
					.param("cognome", "Bl")
				)
				.andExpect(status().isOk())
				.andReturn();
		
		String json = result.getResponse().getContentAsString();
		List<SocioDTO> lS = objectMapper.readValue(
				json,
				new TypeReference<List<SocioDTO>> () {
				});
		
		assertFalse(lS.isEmpty());
		lS.forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	@Order(8)
	public void deleteRest() throws Exception{
		log.debug("deleteRest");
		
		mockMvc.perform(delete("/rest/socio/delete/{id}", 1))
			.andExpect(status().isOk());
	}
	
	@Test
	@Order(9)
	public void ListAllRest() throws Exception{
		log.debug("ListRest");
		
		MvcResult result = mockMvc.perform(get("/rest/socio/list")
				)
				.andExpect(status().isOk())
				.andReturn();
		
		String json = result.getResponse().getContentAsString();
		List<SocioDTO> lS = objectMapper.readValue(
				json,
				new TypeReference<List<SocioDTO>> () {
				});
		
		assertFalse(lS.isEmpty());
		lS.forEach(s -> log.debug(s.toString()));
	}
	
}
