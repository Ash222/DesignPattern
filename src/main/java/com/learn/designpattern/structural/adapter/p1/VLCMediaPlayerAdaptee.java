package com.learn.designpattern.structural.adapter.p1;

public class VLCMediaPlayerAdaptee implements IAdvanceMediaPlayerAdaptee {
	
	@Override
	public void playMedia(final String fileName) {
		System.out.println("Playing vlc file ::: " + fileName);
	}
}
