package com.learn.designpattern.lowleveldesign.pen;

public class Pen {
	
	private String name;
	private String brandName;
	private int price;
	private IWriteStrategy writeStrategy;
	
	public Pen(String name, String brandName, int price,
	           IWriteStrategy writeStrategy) {
		this.name = name;
		this.brandName = brandName;
		this.price = price;
		this.writeStrategy = writeStrategy;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public IWriteStrategy getWriteStrategy() {
		return writeStrategy;
	}
	
	public void write(){
		this.writeStrategy.write();
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Pen{");
		sb.append("name='").append(name).append('\'');
		sb.append(", brandName='").append(brandName).append('\'');
		sb.append(", price=").append(price);
		sb.append('}');
		return sb.toString();
	}
}
