package co.ke.bank.maendeleo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="bank")
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="code", nullable=false, unique=true)
	private String code;
	
	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	@OneToMany(mappedBy = "bank", orphanRemoval=true,
			fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Branch> branches = new ArrayList<Branch>();
	
	@OneToMany(mappedBy = "amount", orphanRemoval=true,
			fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<OtherBankLoan> otherLoans = new ArrayList<OtherBankLoan>();
	
	public Bank() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@JsonIgnore
	public List<Branch> getBranches() {
		return branches;
	}
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	@JsonIgnore
	public List<OtherBankLoan> getOtherLoans() {
		return otherLoans;
	}
	public void setOtherLoans(List<OtherBankLoan> otherLoans) {
		this.otherLoans = otherLoans;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bank [code=").append(code).append(", name=").append(name).append("]");
		return builder.toString();
	}
}
