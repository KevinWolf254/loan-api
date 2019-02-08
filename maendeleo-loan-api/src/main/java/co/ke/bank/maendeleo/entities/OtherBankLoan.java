package co.ke.bank.maendeleo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//to prevent recursion issues
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

//ignore unknown or missing properties during deserialization
@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name="other_bank_loan")
public class OtherBankLoan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="date_granted", nullable=false)
	private String dateGranted;
	
	@Column(name="repayment_period", nullable=false)
	private String repaymentPeriod;
	
	@ManyToOne(fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;
	
	@ManyToOne(fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "amount_id", nullable = false)
	private OtherBankLoanAmount amount;
	
	public OtherBankLoan() {
		super();
	}
	public OtherBankLoan(String dateGranted, String repaymentPeriod, Bank bank, Account account,
			OtherBankLoanAmount amount) {
		super();
		this.dateGranted = dateGranted;
		this.repaymentPeriod = repaymentPeriod;
		this.bank = bank;
		this.account = account;
		this.amount = amount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
//	@JsonIgnore
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	@JsonIgnore
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
//	@JsonIgnore
	public OtherBankLoanAmount getAmount() {
		return amount;
	}
	public void setAmount(OtherBankLoanAmount amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OtherBankLoan [dateGranted=").append(dateGranted).append(", repaymentPeriod=")
				.append(repaymentPeriod).append(", bank=").append(bank).append(", account=").append(account)
				.append(", amount=").append(amount).append("]");
		return builder.toString();
	}
}
