package com.learn.designpattern.behavioral.observer.p1;

public interface IPublisher {
	
	void addObserver(ISubscriber observer);
	
	void removeObserver(ISubscriber observer);
	
	void notifyObservers();
}
