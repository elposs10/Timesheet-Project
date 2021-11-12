package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contrat implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reference;
	
	
	private String dateDebut;
	
	private String typeContrat;
	
	private float salaire;
	

	public Contrat() {
	}


	public int getReference() {
		return reference;
	}


	public void setReference(int reference) {
		this.reference = reference;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}


	public float getSalaire() {
		return salaire;
	}


	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Contrat(String dateDebut, String typeContrat, float salaire) {
		super();
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}


	
	

	
	
	
}
