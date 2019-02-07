package co.ke.bank.maendeleo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import co.ke.bank.maendeleo.enums.Currency;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, 
property="id")
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
	private double amount;
	
	@Column(name="outstanding_balance", nullable=false)
	private double outstandingBalance;
	
	public OtherBankLoanAmount() {
		super();
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getOutstandingBalance() {
		return outstandingBalance;
	}
	public void setOutstandingBalance(double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OtherBankLoanAmount [id=").append(id).append(", currency=").append(currency).append(", amount=")
				.append(amount).append(", outstandingBalance=").append(outstandingBalance).append("]");
		return builder.toString();
	}
}
