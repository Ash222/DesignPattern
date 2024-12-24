package com.learn.designpattern.structural.adapter.p2;

// this is adapter class
public final class LegacyRectangleAdapter implements IShape {
	
	private final LegacyRectangle legacyRectangle;
	
	public LegacyRectangleAdapter() {
		this.legacyRectangle = new LegacyRectangle();
	}
	
	@Override
	public void draw(final int x, final int y, final int width, final int height) {
		
		final int x2 = x + width;
		final int y2 = y + height;
		
		this.legacyRectangle.drawRectangle(x, y, x2, y2);
	}
}
