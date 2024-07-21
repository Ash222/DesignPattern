package com.learn.designpattern.structural.adapter.p1;

// This is the interface that client is going to use to interact with.
public interface IMusicPlayer {
	
	void play(final String audioType,final String fileName);
}
