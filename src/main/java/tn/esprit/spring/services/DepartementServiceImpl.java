package tn.esprit.spring.services;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;



@Service
public class DepartementServiceImpl implements IDepartementService {
	@Autowired
	DepartementRepository deptRepoistory;
	@Override
	public int ajouterDepartement(Departement departement) {
		deptRepoistory.save(departement);
		return departement.getId();
	}

	@Override
	public List<Departement> getAllDepartements() {
		// TODO Auto-generated method stub
		return ((List<Departement>)deptRepoistory.findAll());
	}

	@Override
	public void deleteEmployeById(int departementId) {
		// TODO Auto-generated method stub
		deptRepoistory.deleteById(departementId);
		
	}
	

}
