package com.learn.designpattern.behavioral.observer.p1;

@FunctionalInterface
public interface ISubscriber {
	void update(double temperature);
}
