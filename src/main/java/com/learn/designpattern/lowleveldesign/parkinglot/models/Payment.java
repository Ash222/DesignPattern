package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.Mode;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.PaymentStatus;
import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

public class Payment {
	
	private final int id;
	private final Mode mode;
	private int amount;
	private PaymentStatus paymentStatus;
	
	public Payment(Mode mode) {
		this.id = IDAllocatorUtil.getPaymentId();
		this.mode = mode;
	}
	
	public Payment(Mode mode, int amount, PaymentStatus paymentStatus) {
		this.id = IDAllocatorUtil.getPaymentId();
		this.mode = mode;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}
	
	public int getId() {
		return id;
	}
	
	public Mode getMode() {
		return mode;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
