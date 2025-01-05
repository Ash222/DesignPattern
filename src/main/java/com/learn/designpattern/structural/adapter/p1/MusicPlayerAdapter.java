package com.learn.designpattern.structural.adapter.p1;

public class MusicPlayerAdapter implements IMusicPlayer {
	
	private IAdvanceMediaPlayerAdaptee advanceMediaPlayerAdaptee;
	
	private void setAdvanceMediaPlayerAdaptee(
			final IAdvanceMediaPlayerAdaptee advanceMediaPlayerAdaptee
	) {
		this.advanceMediaPlayerAdaptee = advanceMediaPlayerAdaptee;
	}
	
	@Override
	public void play(final String audioType, final String fileName) {
		createAdaptor(audioType);
		this.advanceMediaPlayerAdaptee.playMedia(fileName);
	}
	
	private void createAdaptor(final String audioType) {
		if (audioType.equalsIgnoreCase("vlc")) {
			setAdvanceMediaPlayerAdaptee(new VLCMediaPlayerAdaptee());
		} else {
			setAdvanceMediaPlayerAdaptee(new DefaultMediaPlayerAdaptee());
		}
	}
}
