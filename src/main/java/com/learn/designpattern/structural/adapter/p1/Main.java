package com.learn.designpattern.structural.adapter.p1;

public class Main {
	
	public static void main(String[] args) {
		
		IMusicPlayer musicPlayer = new MusicPlayerAdapter();
		musicPlayer.play("mp4", "In The End");
		musicPlayer.play("vlc", "Remember The Name");
	}
}
