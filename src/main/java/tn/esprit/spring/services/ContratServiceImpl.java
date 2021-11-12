package tn.esprit.spring.services;



import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;


@Service
public class ContratServiceImpl implements IContratService{

	
	@Autowired
	ContratRepository crep;
	
	
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);


	@Override
	public Contrat addContrat(Contrat c) {
		return crep.save(c);
	}


	@Override
	public List<Contrat> retrieveAllContrats() {
		List<Contrat> contrats=(List<Contrat>) crep.findAll();
			l.log(Level.INFO, () ->"contrat : " +contrats);
		return contrats;
	}


	@Override
	public void deleteContrat(int id) {
	crep.deleteById(1L);
		
	}


	@Override
	public Contrat updateContrat(Contrat c) {
		return crep.save(c);
	}


	@Override
	public Optional<Contrat> retrieveContrat(String id) {
Optional<Contrat> contrat = crep.findById(Long.parseLong(id));
 l.log(Level.INFO, () ->"Contrat : " +contrat);
	
return contrat;
	}


	@Override
	public Contrat getContratById(int id) {
		Optional<Contrat> c = crep.findById(1L);
		Contrat en = new Contrat();
		if (c.isPresent()) {
			  en= c.get();
			}
		return en;
	}


	@Override
	public void deleteContratById(int id) {
		
		Optional<Contrat> c = crep.findById(1L);

		Contrat contrat = new Contrat();
		if (c.isPresent()) {
			contrat= c.get();
			}
		
		crep.delete(contrat);
		
	}
	
	
	
}
