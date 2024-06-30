package com.learn.designpattern.structural.facade.p1;

public class Main {
	
	public static void main(String[] args) {
		
		HomeTheaterFacade homeTheater = new HomeTheaterFacade();
		homeTheater.watchMovie("Inception");
		System.out.println();
		homeTheater.endMovie();
	}
}
