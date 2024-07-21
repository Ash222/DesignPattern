package com.learn.designpattern.behavioral.observer.p1;

public class Main {
	
	public static void main(String[] args) {
		
		ISubscriber phone = new PhoneDisplay();
		ISubscriber web = new WebDisplay();
		WeatherStation weatherStation = new WeatherStation();
		weatherStation.addObserver(phone);
		weatherStation.addObserver(web);
		weatherStation.setTemperature(10.2);
	}
}
