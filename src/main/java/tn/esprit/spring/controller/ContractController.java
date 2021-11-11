package tn.esprit.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RestController
@RequestMapping("/contrat")
public class ContractController {

	@Autowired
	private IContratService contratService;

	@PostMapping({ "", "/" })
	public ResponseEntity<?> addContrat(@RequestBody Contrat contrat) {
		contratService.ajouterContrat(contrat);
		Map<String,String> response = new HashMap<>();
		response.put("message", "INSERTION_SECCES");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getContratById(@PathVariable int id) {
		Contrat contrat = contratService.findOneById(id);
		if (contrat == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(contrat);
	}
	
	@GetMapping({"","/"})
	public ResponseEntity<?> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(contratService.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateContrat(@PathVariable("id") int id, @RequestBody Contrat contrat){
		contrat.setReference(id);
		contratService.updateContrat(contrat);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteContrat(@PathVariable("id")int id){
		contratService.deleteContrat(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
