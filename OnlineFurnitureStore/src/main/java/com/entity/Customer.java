package com.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Customer")
public class Customer extends User{
	
	@OneToOne
	@JoinColumn(name = "address")
	private Address address;
	@OneToOne
	@JoinColumn(name = "account")
	private Account account;
	private String mobileNo;
	private String email;
	@OneToOne
	@JoinColumn(name = "review")
	private Review review;

	public Customer() {
		super();
	}

	public Customer(Address address, Account account, String mobileNo, String email, Review review) {
		super();
		this.address = address;
		this.account = account;
		this.mobileNo = mobileNo;
		this.email = email;
		this.review = review;
	}

	public Address getAddress() {
		return address;
	}

	public Account getAccount() {
		return account;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public Review getReview() {
		return review;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setReview(Review review) {
		this.review = review;
	}
}
