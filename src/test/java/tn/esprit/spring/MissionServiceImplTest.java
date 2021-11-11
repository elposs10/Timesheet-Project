package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.IMissionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	
	private static final long DEFAULT_TIMEOUT = 5000;
	private static final Logger l = LogManager.getLogger(MissionServiceImplTest.class);

	@Autowired
	IMissionService underTest ;
	@Autowired
	MissionRepository missionRepo ;
	
	//adding unit teste
	
				 
			@Test(timeout = DEFAULT_TIMEOUT)
			
			public void testaddMission() {
				Mission mission = new Mission("validation","je valide");
				underTest.ajouterMission(mission);
			assertNotNull(mission.getId());
			l.info("Mission ajoutee correctement ");
			missionRepo.deleteById(mission.getId());
			l.info("Out from addMission() without errors ");
			}
			
			
			@Test
			public void deleteMission() {
				Mission mission = new Mission("validation","je valide");
				underTest.ajouterMission(mission);
				l.info("Mission ajoutee correctement ");
				underTest.deleteMission(mission.getId());
				l.info("Out without Errors!!");
			}
			
			
			
			@Test
			public void testcountMission() {
			long empNbre = missionRepo.count();
			assertNotNull(empNbre);
			l.info("Le Nombre des Employes est :");
			l.info(empNbre);
			l.info("Out without Errors!!");
			}
			
			
			@Test
			public void testListMission() {
			Mission mission = new Mission("validation","je valide");
			underTest.ajouterMission(mission);
			l.info("Mission ajoutee c bon");
			List<Mission> e = (List<Mission>) missionRepo.findAll();
			assertThat(e).size().isPositive();
			l.info( "tester le repo n'est pas vide ");
			missionRepo.deleteById(mission.getId());
			l.info("Out without Errors!!");
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
