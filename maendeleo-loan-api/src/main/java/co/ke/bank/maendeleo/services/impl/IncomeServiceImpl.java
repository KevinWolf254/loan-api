package co.ke.bank.maendeleo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.bank.maendeleo.entities.Income;
import co.ke.bank.maendeleo.entities.Institution;
import co.ke.bank.maendeleo.exceptions.EmploymentDetailsNotFoundException;
import co.ke.bank.maendeleo.repositories.IncomeRepository;
import co.ke.bank.maendeleo.services.IncomeService;
import co.ke.bank.maendeleo.services.InstitutionService;

@Service
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private InstitutionService instituteService;
	@Autowired
	private IncomeRepository repository;
	
	@Override
	public List<Income> read(final int identityNo) throws EmploymentDetailsNotFoundException {
		final Institution institution = instituteService.findByMemberIdentityNo(identityNo);
		
		return repository.findByInstitutionId(institution.getId());
	}

}
