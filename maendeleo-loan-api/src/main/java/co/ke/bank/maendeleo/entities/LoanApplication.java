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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import co.ke.bank.maendeleo.enums.LoanStatus;
import co.ke.bank.maendeleo.enums.LoanType;

//to prevent recursion issues
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//ignore unknown or missing properties during de_serialization
@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name="loan_application")
public class LoanApplication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="type", nullable=false)
	private LoanType type;
	
	@Column(name="purpose", nullable=false)
	private String purpose;
	
	@Column(name="status", nullable=false)
	private LoanStatus status;
	
	@ManyToOne(fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "amount_id", nullable = false)
	private LoanAmount amount;
	
	public LoanApplication(LoanType type, String purpose, LoanStatus status, Account account, LoanAmount amount) {
		super();
		this.type = type;
		this.purpose = purpose;
		this.status = status;
		this.account = account;
		this.amount = amount;
	}
	public LoanApplication() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LoanType getType() {
		return type;
	}
	public void setType(LoanType type) {
		this.type = type;
	}
	public LoanStatus getStatus() {
		return status;
	}
	public void setStatus(LoanStatus status) {
		this.status = status;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	@JsonIgnore
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public LoanAmount getAmount() {
		return amount;
	}
	public void setAmount(LoanAmount amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanApplication [type=").append(type).append(", purpose=").append(purpose).append(", status=")
				.append(status).append(", account=").append(account).append(", amount=").append(amount).append("]");
		return builder.toString();
	}
}
