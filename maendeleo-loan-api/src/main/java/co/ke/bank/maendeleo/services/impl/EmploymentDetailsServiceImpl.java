package co.ke.bank.maendeleo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.bank.maendeleo.entities.EmploymentDetails;
import co.ke.bank.maendeleo.exceptions.EmploymentDetailsNotFoundException;
import co.ke.bank.maendeleo.repositories.EmploymentDetailsRepository;
import co.ke.bank.maendeleo.services.EmploymentDetailsService;

@Service
public class EmploymentDetailsServiceImpl implements EmploymentDetailsService {

	@Autowired
	private EmploymentDetailsRepository repository;
	
	
	@Override
	public EmploymentDetails read(int identityNo) throws EmploymentDetailsNotFoundException {
		final Optional<EmploymentDetails> details = repository.findByMemberIdentityNo(identityNo);
		if(!details.isPresent())
			throw new EmploymentDetailsNotFoundException();
		return details.get();
	}

}
