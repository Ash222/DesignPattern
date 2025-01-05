package com.learn.designpattern.structural.flyweight.p2;

public final class Main {
	
	public static void main(String[] args) {
		
		final Forest forest = new Forest();
		forest.plantTree(1, 1, "Oak", "Green", "Rough");
		forest.plantTree(2, 3, "Pine", "Dark Green",
		                 "Smooth");
		forest.plantTree(1, 2, "Oak", "Green",
		                 "Rough");
		forest.plantTree(3, 5, "Birch", "White",
		                 "Smooth");
		forest.plantTree(4, 4, "Pine", "Dark Green",
		                 "Smooth");
		
		forest.displayTree();
	}
}
