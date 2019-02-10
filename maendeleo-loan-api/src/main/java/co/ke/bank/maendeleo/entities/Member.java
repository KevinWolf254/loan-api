package co.ke.bank.maendeleo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import co.ke.bank.maendeleo.enums.IdentityType;
import co.ke.bank.maendeleo.enums.MaritalStatus;

//to prevent recursion issues
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//ignore unknown or missing properties during de_serialization
@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name="member")
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="identity_type")
	private IdentityType identityType;
	
	@Column(name="identity_no", nullable=false, unique=true)
	private int identityNo;
	
	@Column(name="pin_no", nullable=false, unique=true)
	private String pinNo;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="mobile_no", nullable=false, unique=true)
	private String mobileNo;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="marital_status")
	private MaritalStatus maritalStatus;
	
	@Column(name="dependents")
	private int dependents;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "residence_id", nullable = false)
	private Residence residence;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "postal_address_id", nullable = false)
	private PostalAddress postalAddress;
	
	public Member() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public IdentityType getIdentityType() {
		return identityType;
	}
	public void setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
	}
	public int getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(int identityNo) {
		this.identityNo = identityNo;
	}
	public String getPinNo() {
		return pinNo;
	}
	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public int getDependents() {
		return dependents;
	}
	public void setDependents(int dependents) {
		this.dependents = dependents;
	}
	public Residence getResidence() {
		return residence;
	}
	public void setResidence(Residence residence) {
		this.residence = residence;
	}
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [id=").append(id).append(", identityType=").append(identityType).append(", identityNo=")
				.append(identityNo).append(", pinNo=").append(pinNo).append(", firstName=").append(firstName)
				.append(", middleName=").append(middleName).append(", lastName=").append(lastName).append(", dob=")
				.append(dob).append(", mobileNo=").append(mobileNo).append(", email=").append(email)
				.append(", maritalStatus=").append(maritalStatus).append(", dependents=").append(dependents)
				.append(", residence=").append(residence).append(", postalAddress=").append(postalAddress).append("]");
		return builder.toString();
	}
	
}
