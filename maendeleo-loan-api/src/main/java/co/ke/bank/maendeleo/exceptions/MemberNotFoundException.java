package co.ke.bank.maendeleo.exceptions;

public class MemberNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MemberNotFoundException() {
		super("Member does not exist");
	}
	public MemberNotFoundException(String message) {
		super(message);
	}
}
