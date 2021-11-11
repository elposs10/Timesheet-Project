package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	private ContratRepository contratRepository;

	@Override
	public void ajouterContrat(Contrat contrat) {
		// l'ajout d'un contrat
		contratRepository.save(contrat);
	}

	@Override
	public void deleteContrat(int id) {
		//delete contrat
		contratRepository.deleteById(id);
	}

	@Override
	public Contrat findOneById(int id) {
		//find contrat by Id
		Contrat c = null;
		if (contratRepository.findById(id).isPresent())
			c = contratRepository.findById(id).get();
		return c;
	}

	@Override
	public List<Contrat> findAll() {
		// find all contrats
		List<Contrat> contrats = new ArrayList<>();
		for(Contrat c : contratRepository.findAll()){
			contrats.add(c);
		}
		return contrats;
	}

	@Override
	public void updateContrat(Contrat contrat) {
		// mettre le contrat à jour
		contratRepository.save(contrat);
	}

}
