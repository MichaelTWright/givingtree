package com.michaelwright.givingtree.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;



@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Size(min=1, message="Company Name is Required")
	private String name;
    @Size(min=1, message="Address is Required")
	private String address;
    @Size(min = 10, max = 10, message="Phone number must be 10 digits. No spaces or non-numerical characters")
	private String phone;
    @Size(min = 5, max = 5, message="Zip Code must be 5 digits. No spaces or non-numerical characters")
	private String zip;
    @Size(min = 5, max = 100, message="Password must be more than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
   		 name="banks_companies",
   		 joinColumns = @JoinColumn(name="company_id"),
   		 inverseJoinColumns = @JoinColumn(name="bank_id"))
    private List<Bank> banks;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
   		 name="waiting_approval",
   		 joinColumns = @JoinColumn(name="company_id"),
   		 inverseJoinColumns = @JoinColumn(name="bank_id"))
    private List<Bank> request_banks;
	

	public Company() {

	}

	public Company(String name, String address, String phone, String zip, String password) {
		
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.zip = zip; 
		this.password = password; 

	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public List<Bank> getRequest_banks() {
		return request_banks;
	}

	public void setRequest_banks(List<Bank> request_banks) {
		this.request_banks = request_banks;
	}
	
	
	
}
