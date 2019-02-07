package co.ke.bank.maendeleo.services;

import java.util.List;

import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.pojos.LoanApplicationRequest;
import co.ke.bank.maendeleo.pojos.Response;

public interface LoanApplicationService {

	public Response create(LoanApplicationRequest application);
	
	public List<LoanApplication> read(Long memberIdNo);
	
	public Response update(LoanApplication application);
	
	public Response delete(Long loanId);
}
