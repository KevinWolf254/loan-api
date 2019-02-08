package co.ke.bank.maendeleo.pojos;

import java.util.ArrayList;
import java.util.List;

public class LoanApplicationRequest {

	private int memberId;
	private String bankName;
	private Application application;
	private Amount amount;
	private List<OtherBank> otherLoans = new ArrayList<OtherBank>();
	
	public LoanApplicationRequest() {
		super();
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public List<OtherBank> getOtherLoans() {
		return otherLoans;
	}
	public void setOtherLoans(List<OtherBank> otherLoans) {
		this.otherLoans = otherLoans;
	}
}
