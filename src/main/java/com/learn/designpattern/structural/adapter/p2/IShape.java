package com.learn.designpattern.structural.adapter.p2;

public sealed interface IShape permits LegacyRectangleAdapter, Rectangle {
	
	void draw(final int x, final int y, final int width, final int height);
}
