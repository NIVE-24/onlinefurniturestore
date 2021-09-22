package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private String accountNo;
	private String accountBalance;

	public Account() {
	}

	public Account(int accountid, String accountNo, String accountBalance) {
		this.accountId = accountid;
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
	}

	public int getAccountid() {
		return accountId;
	}

	public void setAccountid(int accountid) {
		this.accountId = accountid;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
}
