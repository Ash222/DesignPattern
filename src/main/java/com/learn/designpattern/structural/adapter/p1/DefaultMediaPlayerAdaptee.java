package com.learn.designpattern.structural.adapter.p1;

public class DefaultMediaPlayerAdaptee implements IAdvanceMediaPlayerAdaptee {
	
	@Override
	public void playMedia(final String fileName) {
		System.out.println("Playing windows player file ::: " + fileName);
	}
}
