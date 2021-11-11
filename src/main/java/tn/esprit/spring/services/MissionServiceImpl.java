package tn.esprit.spring.services;

import java.util.List;

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
	public Mission MissionUpadate(Mission Miss) {
		
		Mission existingMiss=missionRepo.findById(Miss.getId()).orElse(null);
		
		missionRepo.findById(Miss.getId());
		existingMiss.setName(Miss.getName());
		existingMiss.setDescription(Miss.getDescription());
		
		return missionRepo.save(existingMiss);
	}
	
	@Override
	public void deleteMission(int id) {
		missionRepo.deleteById(id);

	}
	
	

}
