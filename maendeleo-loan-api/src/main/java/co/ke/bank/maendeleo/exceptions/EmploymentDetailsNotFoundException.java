package co.ke.bank.maendeleo.exceptions;

public class EmploymentDetailsNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmploymentDetailsNotFoundException() {
		super("Employee does not exist");
	}
	public EmploymentDetailsNotFoundException(String message) {
		super(message);
	}
}
