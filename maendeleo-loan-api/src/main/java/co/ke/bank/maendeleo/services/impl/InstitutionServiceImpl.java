package co.ke.bank.maendeleo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.bank.maendeleo.entities.EmploymentDetails;
import co.ke.bank.maendeleo.entities.Institution;
import co.ke.bank.maendeleo.exceptions.EmploymentDetailsNotFoundException;
import co.ke.bank.maendeleo.exceptions.InstitutionNotFoundException;
import co.ke.bank.maendeleo.repositories.EmploymentDetailsRepository;
import co.ke.bank.maendeleo.repositories.InstitutionRepository;
import co.ke.bank.maendeleo.services.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService {

	@Autowired
	private InstitutionRepository repository;
	@Autowired
	private EmploymentDetailsRepository employeeRepo;

	@Override
	public Institution read(Long id) throws InstitutionNotFoundException {
		final Optional<Institution> institute = repository.findById(id);
		if(!institute.isPresent())
			throw new InstitutionNotFoundException();
		return institute.get();
	}

	@Override
	public Institution findByMemberIdentityNo(int identityNo) throws EmploymentDetailsNotFoundException {
		Optional<EmploymentDetails> employee = employeeRepo.findByMemberIdentityNo(identityNo);	
		if(!employee.isPresent())
			throw new EmploymentDetailsNotFoundException();
		return employee.get().getInstitution();
	}

}
