package tn.esprit.spring.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;


@RestController
public class RestControlDepartement {
	
	@Autowired
	private IDepartementService idepiseservice;
	
	
	
	@PostMapping(value="post-departement")	
	@ResponseBody	
	public Departement ajouterEmploye(@RequestBody Departement departement)
	{
		idepiseservice.ajouterDepartement(departement);
		return departement;
	}
	@GetMapping(path="/test")
	@ResponseBody
	public List<Departement> afficherDepartement(){
		 return idepiseservice.getAllDepartements();
		
		
	}
	@DeleteMapping(value="delete-product")
	public String  deleteProduct(@RequestParam int departementId) {
		idepiseservice.deleteEmployeById( departementId);
		return ( "le produit avec l'id"+departementId+"est supprimè");
		
		
	}
	
}
