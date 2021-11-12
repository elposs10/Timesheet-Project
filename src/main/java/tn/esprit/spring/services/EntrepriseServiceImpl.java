package tn.esprit.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;

	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}

	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		Optional<Departement> depManagedEntity = deptRepoistory.findById(depId);
		if (entrepriseManagedEntity.isPresent()) {
			Entreprise e = entrepriseManagedEntity.get();
			if (depManagedEntity.isPresent()) {
				Departement d = depManagedEntity.get();
				d.setEntreprise(e);
				deptRepoistory.save(d);
			}
		}

	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional<Entreprise> ent = entrepriseRepoistory.findById(entrepriseId);
		if (ent.isPresent()) {
			entrepriseRepoistory.delete(ent.get());
		}

	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> dep = deptRepoistory.findById(depId);
		if (dep.isPresent()) {
			deptRepoistory.delete(dep.get());
		}
	}

}
