/*
 * @author: Aditya Mohapatra
 */

package org.society.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Registered_Society_Voters")
public class RegisteredSocietyVoters implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Voter Id card number must be unique
	@NotNull(message = "Voter Id number can not be null")
	@Column(unique = true)
	private String voterIdCardNo;
	
	@NotNull(message = "Name is Required")
	@Length(min = 2, max = 30, message = "Name size must be between 5 and 30")
	private String firstName;
	
	
	private String lastName;
	
	
	@NotNull(message = "Password is Required")
	@Length(min = 5, max = 15, message = "Name size must be between 5 and 15")
	private String password;
	
	
	@NotNull(message = "Gender is Required")
	private String gender;
	
	@NotBlank(message = "Reservation Category is required")
	private String reservationCategory;
	
	@NotNull(message = "Name is Required")
	@Size(min = 10,max=13, message = "mobile number should be valid")
	private String mobileno;
	
	//@email
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	@NotNull(message = "Email is Required")
	private String emailId;
	
	@NotBlank
	private String addressLine1;
	
	private String addressLine2;
	
	@NotBlank
	private String mandal;
	
	@NotBlank
	private String district;
	
	@NotNull(message = "Pincode is required")
	@Min(6)
	private int pincode;

	private boolean castedVote;
	
	// OneToOne relationship one Voter can have only one Society
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL) //added cascade
	@JoinColumn(name = "cooperative_society_fk")
	private CooperativeSociety cooperativeSociety;

	public RegisteredSocietyVoters() {
		super();
	}

	public RegisteredSocietyVoters(long id, String voterIdCardNo, String firstName, String lastName, String password,
			String gender, String reservationCategory, String mobileno, String emailId, String addressLine1,
			String addressLine2, String mandal, String district, int pincode, boolean castedVote,
			CooperativeSociety cooperativeSociety) {
		super();
		this.id = id;
		this.voterIdCardNo = voterIdCardNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.reservationCategory = reservationCategory;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.mandal = mandal;
		this.district = district;
		this.pincode = pincode;
		this.castedVote = castedVote;
		this.cooperativeSociety = cooperativeSociety;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVoterIdCardNo() {
		return voterIdCardNo;
	}

	public void setVoterIdCardNo(String voterIdCardNo) {
		this.voterIdCardNo = voterIdCardNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReservationCategory() {
		return reservationCategory;
	}

	public void setReservationCategory(String reservationCategory) {
		this.reservationCategory = reservationCategory;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public boolean isCastedVote() {
		return castedVote;
	}

	public void setCastedVote(boolean castedVote) {
		this.castedVote = castedVote;
	}

	public CooperativeSociety getCooperativeSociety() {
		return cooperativeSociety;
	}

	public void setCooperativeSociety(CooperativeSociety cooperativeSociety) {
		this.cooperativeSociety = cooperativeSociety;
	}

	@Override
	public String toString() {
		return "RegisteredSocietyVoters [id=" + id + ", voterIdCardNo=" + voterIdCardNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + ", gender=" + gender + ", reservationCategory="
				+ reservationCategory + ", mobileno=" + mobileno + ", emailId=" + emailId + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", mandal=" + mandal + ", district=" + district
				+ ", pincode=" + pincode + ", castedVote=" + castedVote + ", cooperativeSociety=" + cooperativeSociety
				+ "]";
	}

}