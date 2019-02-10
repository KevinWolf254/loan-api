package co.ke.bank.maendeleo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.ke.bank.maendeleo.entities.Income;
import co.ke.bank.maendeleo.exceptions.EmploymentDetailsNotFoundException;
import co.ke.bank.maendeleo.services.IncomeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IncomeController {
	
	@Autowired
	private IncomeService service;

	@GetMapping(value = "/income/institution/member/{identityNo}")
	public ResponseEntity<Object> read(@PathVariable("identityNo") final int identityNo) throws EmploymentDetailsNotFoundException{
		final List<Income> response = service.read(identityNo);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
