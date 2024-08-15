package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.GateStatus;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.GateType;
import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

public class Gate {
	
	private final int id;
	private Operator operator;
	private final int gateNumber;
	private final GateType gateType;
	private GateStatus gateStatus;
	
	public Gate(int gateNumber, GateType gateType, Operator operator,
	            GateStatus gateStatus) {
		this.id = IDAllocatorUtil.getGateId();
		this.gateNumber = gateNumber;
		this.gateType = gateType;
		this.operator = operator;
		this.gateStatus = gateStatus;
	}
	
	public int getId() {
		return id;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public int getGateNumber() {
		return gateNumber;
	}
	
	public GateType getGateType() {
		return gateType;
	}
	
	public GateStatus getGateStatus() {
		return gateStatus;
	}
	
	public void setGateStatus(GateStatus gateStatus) {
		this.gateStatus = gateStatus;
	}
}
