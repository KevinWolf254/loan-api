package co.ke.bank.maendeleo.services;

import java.util.List;

import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.exceptions.AccountNotFoundException;
import co.ke.bank.maendeleo.exceptions.LoanApplicationNotFoundException;
import co.ke.bank.maendeleo.pojos.ApplicationRequest;
import co.ke.bank.maendeleo.pojos.Response;

public interface LoanApplicationService {
	
	/**
	 * Creates a loan application and saves it to database
	 * @param ApplicationRequest
	 * @return Response
	 * @throws AccountNotFoundException 
	 */
	public Response create(ApplicationRequest application) throws AccountNotFoundException;

	/**
	 * Retrieves all the loan applications made by a member
	 * @param memberIdNo - this is the id or passport number
	 * @return List<LoanApplication>
	 */
	public List<LoanApplication> read(int memberIdNo);
	
	/**
	 * Updates the status of the application
	 * @param LoanApplication
	 * @return Response
	 * @throws LoanApplicationNotFoundException 
	 */
	public Response update(LoanApplication application) throws LoanApplicationNotFoundException;
	
	/**
	 * Deletes a loan application
	 * @param loanId
	 * @return Response
	 */
	public Response delete(Long loanId);

}
