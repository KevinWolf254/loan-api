package co.ke.bank.maendeleo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.ke.bank.maendeleo.enums.Currency;

//ignore unknown or missing properties during de_serialization
@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name="other_bank_loan_amount")
public class OtherBankLoanAmount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="currency", nullable=false)
	private Currency currency;
	
	@Column(name="amount", nullable=false)
	private int amount;
	
	@Column(name="outstanding_balance", nullable=false)
	private int outstandingBalance;
	
	public OtherBankLoanAmount() {
		super();
	}
	public OtherBankLoanAmount(Currency currency, int amount, int outstandingBalance) {
		super();
		this.currency = currency;
		this.amount = amount;
		this.outstandingBalance = outstandingBalance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOutstandingBalance() {
		return outstandingBalance;
	}
	public void setOutstandingBalance(int outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OtherBankLoanAmount [").append(", currency=").append(currency).append(", amount=")
				.append(amount).append(", outstandingBalance=").append(outstandingBalance).append("]");
		return builder.toString();
	}
}
