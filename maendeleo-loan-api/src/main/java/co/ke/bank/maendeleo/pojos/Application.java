package co.ke.bank.maendeleo.pojos;

import co.ke.bank.maendeleo.enums.LoanType;

public class Application {

	private String type;
	private String purpose;
	private String status;
	
	public Application() {
		super();
	}
	public LoanType getType() {
		if(type == "normal")
			return LoanType.NORMAL;
		if(type == "development")
			return LoanType.DEVELOPMENT;
		return LoanType.EMERGENCY;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
