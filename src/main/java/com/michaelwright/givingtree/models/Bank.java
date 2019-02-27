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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "banks")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Size(min=1, message="Charity Name is Required")
	private String name;
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
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
   		 name="banks_companies",
   		 joinColumns = @JoinColumn(name="bank_id"),
   		 inverseJoinColumns = @JoinColumn(name="company_id"))
    private List<Company> companies;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
   		 name="waiting_approval",
   		 joinColumns = @JoinColumn(name="bank_id"),
   		 inverseJoinColumns = @JoinColumn(name="company_id"))
    private List<Company> requests;
	
	public Bank() {

	}

	public Bank(String name, String phone, String zip, String password) {
		
		this.name = name;
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

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<Company> getRequests() {
		return requests;
	}

	public void setRequests(List<Company> requests) {
		this.requests = requests;
	}

	

}
