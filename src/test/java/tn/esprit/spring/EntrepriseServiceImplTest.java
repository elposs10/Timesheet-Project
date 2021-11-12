package tn.esprit.spring;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import org.apache.logging.log4j.LogManager;

@ContextConfiguration(classes = TimesheetSpringBootCoreDataJpaMvcRest1Application.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntrepriseServiceImpl.class)
public class EntrepriseServiceImplTest {
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);
	private static final long DEFAULT_TIMEOUT = 10000;

	@Autowired
	EntrepriseServiceImpl emp;

	@Test(timeout = DEFAULT_TIMEOUT)
	public void ajouterEntrepriseTest() {
		Entreprise e = new Entreprise("ent1", "ent2");
		Entreprise ee = new Entreprise("ent3", "ent4");
		Entreprise eee = new Entreprise("ent5", "ent6");
		try {

			l.info("In ajouterEntrepriseTest() : ");

			emp.ajouterEntreprise(e);
			emp.ajouterEntreprise(ee);
			emp.ajouterEntreprise(eee);
			l.info("Out ajouterEntrepriseTest() without errors.");

		}

		catch (Exception e1) {
			l.error("Erreur dans ajouterEntreprise() : " + e1);
		}

	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void ajouterDepartementTest() {
		Departement d = new Departement("dep1");
		Departement dd = new Departement("dep2");
		Departement ddd = new Departement("dep3");
		try {

			l.info("In ajouterDepartementTest() : ");

			emp.ajouterDepartement(d);
			emp.ajouterDepartement(dd);
			emp.ajouterDepartement(ddd);
			l.info("Out ajouterDepartementTest() without errors.");

		}

		catch (Exception e1) {
			l.error("Erreur dans ajouterDepartementTest() : " + e1);
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
