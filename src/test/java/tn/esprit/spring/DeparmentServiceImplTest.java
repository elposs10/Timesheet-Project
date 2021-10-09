package tn.esprit.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeparmentServiceImplTest {

	private static final Logger l = LogManager.getLogger(DeparmentServiceImplTest.class);
	private static final long DEFAULT_TIMEOUT = 10000;

	@Autowired
	private IDepartementService idepiseservice;

	@Test(timeout = DEFAULT_TIMEOUT)
	public void testAjouterDep() {

		try {
			l.info("In ajouterDepartementTest() : ");
			l.debug("Method Begin.");
			Departement d = new Departement("IT");
			idepiseservice.ajouterDepartement(d);

			l.debug("Method End.");
			l.info("Out of ajouterDepartementTest() without errors.");
		} catch (Exception e) {
			l.error("Error in ajouterDepartementTest() : " + e);
		}

	}

}
