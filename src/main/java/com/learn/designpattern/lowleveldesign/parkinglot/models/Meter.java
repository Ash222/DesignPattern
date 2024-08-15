package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

import java.util.Date;

public class Meter {
	
	private final int id;
	private Date startTime;
	private Date endTime;
	
	public Meter() {
		this.id = IDAllocatorUtil.getMeterId();
	}
	
	public int getId() {
		return id;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
