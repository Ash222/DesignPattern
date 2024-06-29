package com.learn.designpattern.structural.facade.p1;

import com.learn.designpattern.structural.facade.p1.subsystems.Amplifier;
import com.learn.designpattern.structural.facade.p1.subsystems.DVDPlayer;
import com.learn.designpattern.structural.facade.p1.subsystems.Projector;
import com.learn.designpattern.structural.facade.p1.subsystems.Screen;

public class HomeTheaterFacade {
	
	private final DVDPlayer dvdPlayer;
	private final Amplifier amplifier;
	private final Projector projector;
	private final Screen screen;
	
	public HomeTheaterFacade() {
		
		this.dvdPlayer = new DVDPlayer();
		this.amplifier = new Amplifier();
		this.projector = new Projector();
		this.screen = new Screen();
	}
	
	public void watchMovie(String movie) {
		
		System.out.println("Get ready to watch a movie...");
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amplifier.on();
		amplifier.setVolume(5);
		dvdPlayer.on();
		dvdPlayer.play(movie);
	}
	
	public void endMovie() {
		
		System.out.println("Shutting down the home theater...");
		dvdPlayer.stop();
		dvdPlayer.off();
		amplifier.off();
		projector.off();
		screen.up();
	}
}
