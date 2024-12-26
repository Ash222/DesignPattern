package com.learn.designpattern.behavioral.observer.p1;

public class Main {
	
	public static void main(String[] args) {
		
		WeatherStation weatherStation = new WeatherStation();
		weatherStation.addObserver(new PhoneDisplay());
		weatherStation.addObserver(new WebDisplay());
		weatherStation.setTemperature(10.2);
	}
}
