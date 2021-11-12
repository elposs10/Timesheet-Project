package tn.esprit.spring;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);
	private static final long DEFAULT_TIMEOUT = 10000;

	@Autowired
	EntrepriseServiceImpl emp;
	
	
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void ajouterEntrepriseTest() {
		Entreprise e = new Entreprise("ent1", "ent2");

		try {

			l.info("In ajouterEntrepriseTest() : ");

			emp.ajouterEntreprise(e);
			assertThat(e.getName()).contains("ent1");
			emp.deleteEntrepriseById(e.getId());
			l.info("Out ajouterEntrepriseTest() without errors.");

		}

		catch (Exception e1) {
			l.error("Erreur dans ajouterEntreprise() : " + e1);
		}

	}

	

	@Test(timeout = DEFAULT_TIMEOUT)
	public void affecterDepartementEntrepriseTest() {

		try {

			l.info("In affecterDepartementEntrepriseTest()  : ");

			emp.affecterDepartementAEntreprise(1, 1);
			l.info("Out affecterDepartementEntrepriseTest()  without errors.");

		}

		catch (Exception e1) {
			l.error("Erreur dans affecterDepartementEntrepriseTest()  : " + e1);
		}

	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void deleteEntrepriseByIdTest() {

		try {

			l.info("In  deleteEntrepriseByIdTest() : ");
			emp.deleteEntrepriseById(1);

			l.info("Out deleteEntrepriseByIdTest() without errors.");

		}

		catch (Exception e1) {
			l.error("Erreur dans deleteEntrepriseByIdTest(): " + e1);
		}
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void deleteDepartementByIdTest() {

		try {

			l.info("In  deleteDepartementByIdTest() : ");
			emp.deleteDepartementById(1);
			l.info("Out  deleteDepartementByIdTest() without errors.");

		}

		catch (Exception e1) {
			l.error("Erreur dans  deleteDepartementByIdTest(): " + e1);
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
