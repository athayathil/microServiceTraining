package com.myapp.cloud.model;

import java.util.Date;

public class Payment {

	private long txnid;
	private double amount;
	
	private Date trxndate;
	public long getTxnid() {
		return txnid;
	}
	public void setTxnid(long txnid) {
		this.txnid = txnid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTrxndate() {
		return trxndate;
	}
	public void setTrxndate(Date trxndate) {
		this.trxndate = trxndate;
	}
	

}
