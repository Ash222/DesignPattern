package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.BillStatus;
import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

import java.util.Date;
import java.util.List;

public class Bill {
	
	private final int id;
	private final Ticket ticket;
	private final int amount;
	private final Date exitTime;
	private final Gate exitGate;
	private List<Payment> paymentList;
	private BillStatus billStatus;
	
	public Bill(Ticket ticket, int amount, Date exitTime, Gate exitGate,
	            List<Payment> paymentList, BillStatus billStatus) {
		this.id = IDAllocatorUtil.getBillId();
		this.ticket = ticket;
		this.amount = amount;
		this.exitTime = exitTime;
		this.exitGate = exitGate;
		this.paymentList = paymentList;
		this.billStatus = billStatus;
	}
	
	public int getId() {
		return id;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public Date getExitTime() {
		return exitTime;
	}
	
	public Gate getExitGate() {
		return exitGate;
	}
	
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}
	
	public BillStatus getBillStatus() {
		return billStatus;
	}
	
	public void setBillStatus(BillStatus billStatus) {
		this.billStatus = billStatus;
	}
}
