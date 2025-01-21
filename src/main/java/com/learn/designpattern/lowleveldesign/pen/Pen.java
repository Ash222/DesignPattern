package com.learn.designpattern.lowleveldesign.pen;

public class Pen {
	
	private final String name;
	private final String brandName;
	private final int price;
	private final IWriteStrategy writeStrategy;
	
	public Pen(final String name, final String brandName, final int price,
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
	
	public void write() {
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
