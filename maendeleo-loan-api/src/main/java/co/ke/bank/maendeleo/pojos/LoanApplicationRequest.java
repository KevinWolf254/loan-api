package co.ke.bank.maendeleo.pojos;

import java.util.ArrayList;
import java.util.List;

import co.ke.bank.maendeleo.entities.LoanAmount;
import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.entities.OtherBankLoan;

public class LoanApplicationRequest {

	private Long memberId;
	private Application application;
	private Amount amount;
	private List<OtherBank> otherLoans = new ArrayList<OtherBank>();
	
	public LoanApplicationRequest() {
		super();
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
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
