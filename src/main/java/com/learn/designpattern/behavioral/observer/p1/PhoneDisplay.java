package com.learn.designpattern.behavioral.observer.p1;

public class PhoneDisplay implements ISubscriber {
	
	@Override
	public void update(final double temperature) {
		System.out.println("Web Display: Current temperature is " + temperature + "°C");
	}
}
