package com.betacom.jpa.abbonamento;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.betacom.jpa.dto.input.AbbonamentoReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.dto.output.SocioDTO;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AbbonamentoTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@Order(1)
	public void createAbbonamentoTest() throws Exception{
		log.debug("createAbbonamentoTest");
		AbbonamentoReq req = new AbbonamentoReq();
		req.setDataAbbonamento(LocalDate.now());
		req.setSocioID(2);
		
		mockMvc.perform(post("/rest/abbonamento/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
		
	}

	@Test
	@Order(2)
	public void createAbbonamentoTestError() throws Exception{
		log.debug("createAbbonamentoTestError");
		AbbonamentoReq req = new AbbonamentoReq();
		req.setDataAbbonamento(LocalDate.now());
		
		MvcResult result =  mockMvc.perform(post("/rest/abbonamento/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isBadRequest())		 
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc create :{}", dto.getMsg());
		
	}

	@Test
	@Order(3)
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
		
	//	assertFalse(lS.isEmpty());
		lS.forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	@Order(4)
	public void updateAbbonamentoTest() throws Exception{
		log.debug("updateAbbonamentoTest");
		AbbonamentoReq req = new AbbonamentoReq();
		req.setDataAbbonamento(LocalDate.now());
		req.setSocioID(2);
		req.setDataAbbonamento(LocalDate.parse("2026-11-09"));
		req.setId(1);
		
		MvcResult result = mockMvc.perform(patch("/rest/abbonamento/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isOk())
		.andReturn();

		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc update :{}", dto.getMsg());
	}
	
	
	@Test
	@Order (5)
	public void addAttivitaAbbonamentoTest() throws Exception{
		log.debug("addAttivitaAbbonamentoTest");
		AbbonamentoReq req = new AbbonamentoReq();
		req.setId(1);
		req.setAttivitaID(2);
		
		
		MvcResult result = mockMvc.perform(post("/rest/abbonamento/createAbbonamentoAttivita")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isOk())
		.andReturn();

		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc add attivita :{}", dto.getMsg());
		
	}
	
	@Test
	@Order (6)
	public void addAttivitaAbbonamentoTestError() throws Exception{
		log.debug("addAttivitaAbbonamentoTestError");
		AbbonamentoReq req = new AbbonamentoReq();
		req.setId(1);
		req.setAttivitaID(2);
		
		
		MvcResult result = mockMvc.perform(post("/rest/abbonamento/createAbbonamentoAttivita")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isBadRequest())
		.andReturn();

		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("rc add attivita error :{}", dto.getMsg());
		
	}
	
	@Test
	@Order (7)
	public void deleteAttivitaAbbonamentoTest() throws Exception{
		log.debug("deleteAttivitaAbbonamentoTest");
		AbbonamentoReq req = new AbbonamentoReq();
		req.setId(1);
		req.setAttivitaID(3);
		
		
		MvcResult result = mockMvc.perform(post("/rest/abbonamento/createAbbonamentoAttivita")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				)
		.andExpect(status().isOk())
		.andReturn();

		String json = result.getResponse().getContentAsString();
		ResponseDTO dto = objectMapper.readValue(json, ResponseDTO.class);
		
		log.debug("attivita creata :{}", dto.getMsg());
		
		mockMvc.perform(delete("/rest/abbonamento/deleteAbbonamentoAttivita/" +  "1" + "/" + "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.msg").exists());
		
		log.debug("Attivita deleted....");
	}
}
