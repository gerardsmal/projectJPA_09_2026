package com.betacom.jpa.attivita;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.betacom.jpa.dto.input.AttivitaReq;
import com.betacom.jpa.dto.output.AttivitaDTO;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AttivitaTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@Order (1)
	public void createAttivitaTest() throws Exception {
		log.debug("createAttivitaTest");
		List<String> lA = List.of("attivita 1", "attivita 2", "attivita 3", "attivita 4" );
		lA.forEach(a -> {
			AttivitaReq req = new AttivitaReq();
			req.setDescrizione(a);
			req.setPrezzo(100L);
			
			try {
				mockMvc.perform(post("/rest/attivita/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(req))
						).andExpect(status().isOk());
			} catch (Exception e) {
				log.error("Error in create {}", e.getMessage());
			}
		});				
	}
	
	@Test
	@Order(2)
	public void listAllAttivita() throws Exception{
		log.debug("listAllAttivita");
		
		MvcResult result = mockMvc.perform(get("/rest/attivita/list"))
	            .andExpect(status().isOk())
	            .andReturn();
		  
		String json = result.getResponse().getContentAsString();
		
		List<AttivitaDTO> lS = objectMapper.readValue(
	            json,
	            new TypeReference<List<AttivitaDTO>>() {}
	    );
		
		assertFalse(lS.isEmpty());
		
		lS.forEach(s -> log.debug(s.toString()));
		
	}

	@Test
	@Order (3)
	public void updateAttivitaTest() throws Exception {
		log.debug("createAttivitaTest");
		AttivitaReq req = new AttivitaReq();
		req.setId(3);
		req.setPrezzo(150L);
			
		mockMvc.perform(patch("/rest/attivita/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(req))
				).andExpect(status().isOk());
	}

//	@Test
//	@Order(4)
//	public void getByIdAttivita() throws Exception{
//		log.debug("getByIdAttivita");
//		
//		MvcResult result = mockMvc.perform(get("/rest/attivita/getById").param("id", "3"))
//	            .andExpect(status().isOk())
//	            .andReturn();
//		  
//		String json = result.getResponse().getContentAsString();
//		
//		AttivitaDTO a = objectMapper.readValue(json,AttivitaDTO.class);
//		
//		log.debug(a.toString());
//	} 

	@Test
	@Order(5)
	public void deleteAttivita() throws Exception{
		log.debug("deleteAttivita");
		
		mockMvc.perform(delete("/rest/attivita/delete/" +  "4"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.msg").exists());
		  
	}

	
}
