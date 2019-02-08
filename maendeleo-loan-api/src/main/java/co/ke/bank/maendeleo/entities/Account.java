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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, 
property="id")
@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="number", nullable=false, unique=true)
	private String number;
	
	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "branch_id", nullable = false)
	private Branch branch;
	
	@OneToMany(mappedBy = "account", orphanRemoval=true,
			fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<LoanApplication> loanApplications = new ArrayList<LoanApplication>();
	
	@OneToMany(mappedBy = "account", orphanRemoval=true,
			fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<OtherBankLoan> otherLoans = new ArrayList<OtherBankLoan>();
	
	public Account() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	@JsonIgnore
	public List<LoanApplication> getLoanApplications() {
		return loanApplications;
	}
	public void setLoanApplications(List<LoanApplication> loanApplications) {
		this.loanApplications = loanApplications;
	}
	@JsonIgnore
	public List<OtherBankLoan> getOtherLoans() {
		return otherLoans;
	}
	public void setOtherLoans(List<OtherBankLoan> otherLoans) {
		this.otherLoans = otherLoans;
	}
}
