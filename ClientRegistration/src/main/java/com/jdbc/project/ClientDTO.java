package com.jdbc.project;

import java.time.LocalDate;

// DTO class
public class ClientDTO {
	private Integer clientId;
	private String name;
	private Gender gender;
	private LocalDate doj;
	private String contactNo;
	private String emailID;
	private String aadharNo;
	private String panNo;
	private String Address;

	public ClientDTO(String name, Gender gender, LocalDate doj, String contactNo, String emailID, String aadharNo,
			String panNo, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.doj = doj;
		this.contactNo = contactNo;
		this.emailID = emailID;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		Address = address;
	}

	public ClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ClientDTO [name=" + name + ", gender=" + gender + ", doj=" + doj + ", contactNo=" + contactNo
				+ ", emailID=" + emailID + ", aadharNo=" + aadharNo + ", panNo=" + panNo + ", Address=" + Address + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public ClientDTO(Integer clientId, String name, Gender gender, LocalDate doj, String contactNo, String emailID,
			String aadharNo, String panNo, String address) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.gender = gender;
		this.doj = doj;
		this.contactNo = contactNo;
		this.emailID = emailID;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		Address = address;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

}
