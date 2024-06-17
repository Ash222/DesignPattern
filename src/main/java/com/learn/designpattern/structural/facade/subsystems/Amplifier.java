package com.learn.designpattern.structural.facade.subsystems;

public class Amplifier {
	
	public void on() {
		System.out.println("Amplifier is ON");
	}
	
	public void setVolume(int level) {
		System.out.println("Setting volume to " + level);
	}
	
	public void off() {
		System.out.println("Amplifier is OFF");
	}
}
