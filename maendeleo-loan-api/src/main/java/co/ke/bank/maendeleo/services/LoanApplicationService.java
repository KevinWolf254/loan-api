package co.ke.bank.maendeleo.services;

import java.util.List;

import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.pojos.ApplicationRequest;
import co.ke.bank.maendeleo.pojos.Response;

public interface LoanApplicationService {
	
	public Response create(ApplicationRequest application);

	public List<LoanApplication> read(int memberIdNo);
	
	public Response update(LoanApplication application);
	
	public Response delete(Long loanId);

}
