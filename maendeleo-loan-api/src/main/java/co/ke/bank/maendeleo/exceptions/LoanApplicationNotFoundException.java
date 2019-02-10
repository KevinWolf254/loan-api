package co.ke.bank.maendeleo.exceptions;

public class LoanApplicationNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LoanApplicationNotFoundException() {
		super("Loan Application does not exist");
	}
	public LoanApplicationNotFoundException(String message) {
		super(message);
	}
}
