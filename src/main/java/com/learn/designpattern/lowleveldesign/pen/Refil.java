package com.learn.designpattern.lowleveldesign.pen;

public class Refil {
	
	private final Nib nib;
	private final Ink ink;
	
	public Refil(final Nib nib, final Ink ink) {
		this.nib = nib;
		this.ink = ink;
	}
	
	public Nib getNib() {
		return nib;
	}
	
	public Ink getInk() {
		return ink;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Refil{");
		sb.append("nib=").append(nib);
		sb.append(", ink=").append(ink);
		sb.append('}');
		return sb.toString();
	}
}
