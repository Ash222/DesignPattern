package com.learn.designpattern.design.pen;

public class Refil {
	
	private Nib nib;
	private Ink ink;
	
	public Refil(Nib nib, Ink ink) {
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
