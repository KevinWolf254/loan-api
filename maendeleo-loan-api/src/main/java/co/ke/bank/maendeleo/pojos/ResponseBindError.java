package co.ke.bank.maendeleo.pojos;

import java.util.ArrayList;
import java.util.List;

public class ResponseBindError extends ResponseError{

	private List<String> validationErrors = new ArrayList<String>();

	public ResponseBindError() {
		super();
	}
	public ResponseBindError(int code, String desc, List<String> validationErrors) {
		super(code, desc);
		this.validationErrors = validationErrors;
	}
	public List<String> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}

}
