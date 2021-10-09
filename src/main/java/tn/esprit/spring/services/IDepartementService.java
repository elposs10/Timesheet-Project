package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;


public interface IDepartementService {
	public int ajouterDepartement(Departement departement);
	public List<Departement> getAllDepartements();
	public void deleteEmployeById(int departementId);
}
