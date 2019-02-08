package co.ke.bank.maendeleo.pojos;

public class OtherBank extends Amount{

	private String bankName;
	private String dateGranted;
	private String repaymentPeriod;
	private int outStandingBalance;
	
	public OtherBank() {
		super();
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getDateGranted() {
		return dateGranted;
	}
	public void setDateGranted(String dateGranted) {
		this.dateGranted = dateGranted;
	}
	public String getRepaymentPeriod() {
		return repaymentPeriod;
	}
	public void setRepaymentPeriod(String repaymentPeriod) {
		this.repaymentPeriod = repaymentPeriod;
	}
	public int getOutStandingBalance() {
		return outStandingBalance;
	}
	public void setOutStandingBalance(int outStandingBalance) {
		this.outStandingBalance = outStandingBalance;
	}
}
