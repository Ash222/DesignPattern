package com.learn.designpattern.behavioral.observer.p1;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements IPublisher {
	
	private final List<ISubscriber> subscriberList;
	private double temperature;
	
	public WeatherStation() {
		this.subscriberList = new ArrayList<>();
	}
	
	public void setTemperature(final double temperature) {
		this.temperature = temperature;
		notifyObservers();
	}
	
	@Override
	public void addObserver(final ISubscriber subscriber) {
		this.subscriberList.add(subscriber);
	}
	
	@Override
	public void removeObserver(final ISubscriber subscriber) {
		this.subscriberList.remove(subscriber);
	}
	
	@Override
	public void notifyObservers() {
		
		for (ISubscriber subscriber : this.subscriberList) {
			subscriber.update(this.temperature);
		}
	}
}
