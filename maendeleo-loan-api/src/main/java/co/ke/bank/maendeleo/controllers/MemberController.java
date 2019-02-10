package co.ke.bank.maendeleo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.ke.bank.maendeleo.entities.Member;
import co.ke.bank.maendeleo.exceptions.MemberNotFoundException;
import co.ke.bank.maendeleo.services.MemberService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping(value = "/member/{identityNo}")
	public ResponseEntity<Object> read(@PathVariable("identityNo") final int identityNo) throws MemberNotFoundException{
		final Member response = service.read(identityNo);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
