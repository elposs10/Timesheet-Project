package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	
	public long ajouterMission(Mission mission);

	public void deleteMission(int id);

	public List<Mission> getMissions();

	public long getMissionNumber();

	public Mission MissionUpadate(Mission Miss);

}
