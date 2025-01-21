package com.learn.designpattern.lowleveldesign.pen;

public class GelPen extends Pen {
	
	private final Refil refil;
	
	public GelPen(final Refil refil, final String name, final String brandName,
			final int price, final IWriteStrategy writeStrategy) {
		super(name, brandName, price, writeStrategy);
		this.refil = refil;
	}
	
	public Refil getRefil() {
		return refil;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("GelPen{");
		sb.append("name='").append(this.getName()).append('\'');
		sb.append(", brandName='").append(this.getBrandName()).append('\'');
		sb.append(", price=").append(this.getPrice());
		sb.append(", refil=").append(refil);
		sb.append('}');
		return sb.toString();
	}
}
