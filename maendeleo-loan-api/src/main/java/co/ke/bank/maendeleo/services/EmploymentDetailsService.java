package co.ke.bank.maendeleo.services;

import co.ke.bank.maendeleo.entities.EmploymentDetails;
import co.ke.bank.maendeleo.exceptions.EmploymentDetailsNotFoundException;

public interface EmploymentDetailsService {

	public EmploymentDetails read(int identityNo) throws EmploymentDetailsNotFoundException;

}
