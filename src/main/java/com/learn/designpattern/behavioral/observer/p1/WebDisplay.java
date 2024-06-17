package com.learn.designpattern.behavioral.observer.p1;

public class WebDisplay implements ISubscriber {
	
	@Override
	public void update(final double temperature) {
		System.out.println("Phone Display: Current temperature is " + temperature + "°C");
	}
}
