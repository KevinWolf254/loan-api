package co.ke.bank.maendeleo.services;

import java.util.List;

import co.ke.bank.maendeleo.entities.Income;
import co.ke.bank.maendeleo.exceptions.EmploymentDetailsNotFoundException;

public interface IncomeService {

	public List<Income> read(int identityNo) throws EmploymentDetailsNotFoundException;

}
