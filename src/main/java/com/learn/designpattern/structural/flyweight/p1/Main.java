package com.learn.designpattern.structural.flyweight.p1;

public class Main {
	
	private static int x = 0;
	
	public static void main(String[] args) {
		
		final Robot humanoidRobot = (Robot) RobotFactory.getRobot("HUMANOID");
		final Robot dogRobot = (Robot) RobotFactory.getRobot("DOG");
		final Robot robot = (Robot) RobotFactory.getRobot("FISH");
		
		display(humanoidRobot);
		display(dogRobot);
		display(robot);
	}
	
	private static void display(final IRobotFlyWeight robot) {
		
		for (int i = 0; i < 10; i++, x++) {
			robot.display(x, x);
		}
	}
}
