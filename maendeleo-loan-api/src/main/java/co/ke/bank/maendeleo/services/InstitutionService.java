package co.ke.bank.maendeleo.services;

import co.ke.bank.maendeleo.entities.Institution;
import co.ke.bank.maendeleo.exceptions.EmploymentDetailsNotFoundException;
import co.ke.bank.maendeleo.exceptions.InstitutionNotFoundException;

public interface InstitutionService {

	public Institution read(Long id) throws InstitutionNotFoundException;
	
	public Institution findByMemberIdentityNo(int identityNo) throws EmploymentDetailsNotFoundException;
	

}
