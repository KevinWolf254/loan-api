package co.ke.bank.maendeleo.exceptions;

public class InstitutionNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InstitutionNotFoundException() {
		super("Institution does not exist");
	}
	public InstitutionNotFoundException(String message) {
		super(message);
	}
}
