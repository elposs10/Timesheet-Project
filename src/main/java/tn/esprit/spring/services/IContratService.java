package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {
	
	public Contrat addContrat(Contrat c);
	public List<Contrat> retrieveAllContrats();
	public void deleteContrat(int id);
	public Contrat updateContrat(Contrat c);
	public Optional<Contrat> retrieveContrat(String id);
	public Contrat getContratById(int id);
	public void deleteContratById(int id);
}
