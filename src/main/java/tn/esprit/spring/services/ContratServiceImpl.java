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
		// TODO Auto-generated method stub
		contratRepository.save(contrat);
	}

	@Override
	public void deleteContrat(int id) {
		// TODO Auto-generated method stub
		contratRepository.deleteById(id);
	}

	@Override
	public Contrat findOneById(int id) {
		// TODO Auto-generated method stub
		Contrat c = null;
		if (contratRepository.findById(id).isPresent())
			c = contratRepository.findById(id).get();
		return c;
	}

	@Override
	public List<Contrat> findAll() {
		// TODO Auto-generated method stub
		List<Contrat> contrats = new ArrayList<>();
		for(Contrat c : contratRepository.findAll()){
			contrats.add(c);
		}
		return contrats;
	}

	@Override
	public void updateContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		contratRepository.save(contrat);
	}

}
