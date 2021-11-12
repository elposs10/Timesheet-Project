package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Generated;

@Generated
public interface DepartementRepository extends CrudRepository<Departement, Integer>{
	public Departement  findByName(String name);

}
