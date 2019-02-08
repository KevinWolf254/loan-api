package co.ke.bank.maendeleo.pojos;

import java.util.ArrayList;
import java.util.List;

import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.entities.OtherBankLoan;

public class ApplicationRequest {

	private int identityNo;
	private LoanApplication loan;
	private List<OtherBankLoan> otherLoans = new ArrayList<OtherBankLoan>();

	public ApplicationRequest() {
		super();
	}
	public int getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(int identityNo) {
		this.identityNo = identityNo;
	}
	public LoanApplication getLoan() {
		return loan;
	}
	public void setLoan(LoanApplication loan) {
		this.loan = loan;
	}
	public List<OtherBankLoan> getOtherLoans() {
		return otherLoans;
	}
	public void setOtherLoans(List<OtherBankLoan> otherLoans) {
		this.otherLoans = otherLoans;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApplicationRequest [identityNo=").append(identityNo).append(", loan=").append(loan)
				.append(", otherLoans=").append(otherLoans).append("]");
		return builder.toString();
	}
	
}
