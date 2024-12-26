package com.learn.designpattern.creational.prototype;

@FunctionalInterface
public interface IPrototype<T> {
    T getClone();
}