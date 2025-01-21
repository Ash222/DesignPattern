package com.learn.designpattern.lowleveldesign.pen;

public class FountainPen extends Pen {
	
	private final Nib nib;
	private final Ink ink;
	
	public FountainPen(final Nib nib, final Ink ink, final String name,
			final String brandName, final int price, final IWriteStrategy writeStrategy) {
		super(name, brandName, price, writeStrategy);
		this.nib = nib;
		this.ink = ink;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("FountainPen{");
		sb.append("name='").append(this.getName()).append('\'');
		sb.append(", brandName='").append(this.getBrandName()).append('\'');
		sb.append(", price=").append(this.getPrice());
		sb.append(", nib=").append(nib);
		sb.append(", ink=").append(ink);
		sb.append('}');
		return sb.toString();
	}
}
