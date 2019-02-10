package co.ke.bank.maendeleo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.ke.bank.maendeleo.entities.Institution;
import co.ke.bank.maendeleo.exceptions.EmploymentDetailsNotFoundException;
import co.ke.bank.maendeleo.exceptions.InstitutionNotFoundException;
import co.ke.bank.maendeleo.services.InstitutionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InstitutionController {
	
	@Autowired
	private InstitutionService service;

	@GetMapping(value = "/institution/{id}")
	public ResponseEntity<Object> read(@PathVariable("id") final Long id) throws InstitutionNotFoundException{
		final Institution response = service.read(id);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/institution/member/{identityNo}")
	public ResponseEntity<Object> findByMemberIdentityNo(@PathVariable("identityNo") final int identityNo) throws EmploymentDetailsNotFoundException{
		final Institution response = service.findByMemberIdentityNo(identityNo);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
