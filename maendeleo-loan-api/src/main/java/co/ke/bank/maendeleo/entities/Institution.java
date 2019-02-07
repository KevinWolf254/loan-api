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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import co.ke.bank.maendeleo.enums.Industry;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, 
property="id")
@Entity
@Table(name="institution")
public class Institution {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	@Column(name="phone_no", nullable=false, unique=true)
	private String phoneNo;
	
	@Column(name="industry")
	private Industry industry;
	
	@Column(name="years_operational")
	private int yearsOperational;
	
	@OneToOne(fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "postal_address_id", nullable = false)
	private PostalAddress postalAddress;
	
	@OneToOne(fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "residence_id", nullable = false)
	private Residence residence;
	
	@OneToMany(mappedBy = "institution", orphanRemoval=true,
			fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Income> incomes = new ArrayList<Income>();

	@OneToMany(mappedBy = "institution", orphanRemoval=true,
			fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<EmploymentDetails> contracts = new ArrayList<EmploymentDetails>();
	
	public Institution() {
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public int getYearsOperational() {
		return yearsOperational;
	}
	public void setYearsOperational(int yearsOperational) {
		this.yearsOperational = yearsOperational;
	}
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}
	public Residence getResidence() {
		return residence;
	}
	public void setResidence(Residence residence) {
		this.residence = residence;
	}
	public List<Income> getIncomes() {
		return incomes;
	}
	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}
	public List<EmploymentDetails> getContracts() {
		return contracts;
	}
	public void setContracts(List<EmploymentDetails> contracts) {
		this.contracts = contracts;
	}
}
