package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionService{
	
	@Autowired
	MissionRepository missionRepo ;
	
	
	@Override
	public long ajouterMission(Mission mission) {
		 missionRepo.save(mission);
		 return (mission).getId();
		
	}
	
	@Override
	public List<Mission> getMissions() {
		return (List<Mission>) missionRepo.findAll();
	}
	
	@Override
	public long getMissionNumber() {
		return missionRepo.count();
	}
	
	@Override
	public void missionUpadate(Mission miss) {
		
		Optional<Mission> existMiss = missionRepo.findById(miss.getId());
		if (existMiss.isPresent()) {
			Mission m = existMiss.get();
			m.setName(miss.getName());
			m.setDescription(miss.getDescription());
			missionRepo.save(m);
		}
			

	}
	
	@Override
	public void deleteMission(int id) {
		missionRepo.deleteById(id);

	}
	
	

}
