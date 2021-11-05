package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {
	
	void ajouterContrat(Contrat contrat);
	void deleteContrat(int id);
	Contrat findOneById(int id);
	List<Contrat> findAll();
	void updateContrat(Contrat contrat);
}
