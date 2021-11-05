package tn.esprit.spring;

import java.util.Date;
import java.util.Map;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.entities.Contrat;

@SpringBootTest
@AutoConfigureMockMvc
class TimesheetApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testAddContrat(){
		Contrat contrat = new Contrat();
		contrat.setDateDebut(new Date());
		contrat.setEmploye(null);
		contrat.setSalaire(20000f);
		
		try{
		String contratJson = mapper.writeValueAsString(contrat);
		MvcResult queryResult = mockMvc.perform(MockMvcRequestBuilders.post("/contrat").content(contratJson).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String res= queryResult.getResponse().getContentAsString();
		
		Map<String, String> response = mapper.readValue(res, Map.class);
		
		assert String.valueOf(response.get("message")).equals("INSERTION_SECCES");
		
		}catch (JsonProcessingException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
