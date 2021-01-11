package com.ING.BankAccountKata.domain;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long accountid;
	private BigDecimal amount;
	private String name;
	private String status;
	private Date date;
	public Long getAccountid() {
		return accountid;
	}
	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal i) {
		this.amount = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Account(Long accountid, BigDecimal amount, String name, String status, Date date) {
		super();
		this.accountid = accountid;
		this.amount = amount;
		this.name = name;
		this.status = status;
		this.date = date;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", amount=" + amount + ", name=" + name + ", status=" + status
				+ ", date=" + date + "]";
	}

	}


