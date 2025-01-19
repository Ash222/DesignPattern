package com.learn.designpattern.lowleveldesign.elevator.pattern.strategy.elevator;

import com.learn.designpattern.lowleveldesign.elevator.entity.ElevatorThreadTask;
import com.learn.designpattern.lowleveldesign.elevator.entity.MovingDirection;

import java.util.List;

public class MinimumDistanceElevatorSelectionStrategy implements
		IElevatorSelectionStrategy {
	
	@Override
	public ElevatorThreadTask selectElevatorTask(
			final List<ElevatorThreadTask> elevatorThreadTaskList, final int floorNumber,
			final MovingDirection movingDirection
	) {
		
		ElevatorThreadTask elevatorThreadTask = null;
		int minDistance = Integer.MAX_VALUE;
		
		for (final ElevatorThreadTask elevatorTask : elevatorThreadTaskList) {
			
			if (elevatorTask.getElevator().getDisplay().getMovingDirection() !=
					movingDirection) {
				continue;
			}
			
			final int currentElevatorFloor = elevatorTask.getElevator().getDisplay()
			                                             .getFloorNumber();
			final int distance = Math.abs(currentElevatorFloor - floorNumber);
			
			if (distance < minDistance) {
				minDistance = distance;
				elevatorThreadTask = elevatorTask;
			}
		}
		
		return elevatorThreadTask;
	}
}
