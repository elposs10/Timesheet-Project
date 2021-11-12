package tn.esprit.spring.test;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.ContratServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContratTest {
	
private static final Logger L = LogManager.getLogger();
	
	@Autowired
	ContratServiceImpl cservice;
	@Autowired
	ContratRepository crep;
	@Test
	//haha h
	void contextLoads() {
	}
	

	  @Test
		public void addContratTest()throws ParseException{
				
		  Contrat c = new Contrat("12-01-2001","type1",1200);
		  cservice.addContrat(c);
		L.log(Level.INFO, () ->"Contrat ajouté : " +c);

		}
	  @Test
		public void testRetrieveContratt() {
			List<Contrat> c = cservice.retrieveAllContrats();
			
			L.log(Level.INFO, () ->"retrieve Contrat : " +c);
		}
	  @Test
		public void testdeleteContrat(){
		  cservice.deleteContrat(1);	
		}
	  @Test
		public void testUpdateContrat () {
		  Contrat c = crep.findContratByReference(1).get(0);
			c.setSalaire(1200);
			crep.save(c);
			
		}

}
