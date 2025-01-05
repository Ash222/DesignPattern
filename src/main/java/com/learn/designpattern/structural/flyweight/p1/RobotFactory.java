package com.learn.designpattern.structural.flyweight.p1;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
	
	private static final Map<String, IRobotFlyWeight> robotFlyWeightMap = new HashMap<>();
	
	private RobotFactory() {
	}

	public static IRobotFlyWeight getRobot(String robotType) {
		
		if (!robotFlyWeightMap.containsKey(robotType)) {
			
			final Look looks = new Look();
			final Robot robot;
			
			switch (robotType) {
				case "HUMANOID", "DOG" -> robot = new Robot(robotType, looks);
				default -> {
					robotType = "DEFAULT";
					robot = new Robot(robotType, looks);
				}
			}
			
			robotFlyWeightMap.put(robotType, robot);
		}
		
		return robotFlyWeightMap.get(robotType);
	}
}
