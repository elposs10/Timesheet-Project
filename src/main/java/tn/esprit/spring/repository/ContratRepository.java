package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Generated;
@Generated
@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer> {

}
