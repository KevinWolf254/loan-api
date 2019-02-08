package co.ke.bank.maendeleo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.pojos.ApplicationRequest;
import co.ke.bank.maendeleo.pojos.Response;
import co.ke.bank.maendeleo.services.LoanApplicationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoanApplicationController {

	@Autowired
	private LoanApplicationService service;
	
	@PostMapping(value = "/loan")
	public ResponseEntity<Object> create(@RequestBody final ApplicationRequest application){
		final Response response = service.create(application);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/loan/{memberIdNo}")
	public ResponseEntity<Object> read(@PathVariable("memberIdNo") final int memberIdNo){
		final List<LoanApplication> response = service.read(memberIdNo);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PutMapping(value = "/loan")
	public ResponseEntity<Object> update(@RequestBody final LoanApplication application){
		final Response response = service.update(application);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/loan/{loanId}")
	public ResponseEntity<Object> delete(@PathVariable("loanId") final Long loanId){
		final Response response = service.delete(loanId);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
