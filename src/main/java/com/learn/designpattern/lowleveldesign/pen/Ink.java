package com.learn.designpattern.lowleveldesign.pen;

public class Ink {
	
	private String color;
	private InkType inkType;
	
	public Ink(String color, InkType inkType) {
		this.color = color;
		this.inkType = inkType;
	}
	
	public String getColor() {
		return color;
	}
	
	public InkType getInkType() {
		return inkType;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Ink{");
		sb.append("color='").append(color).append('\'');
		sb.append(", inkType=").append(inkType);
		sb.append('}');
		return sb.toString();
	}
}
