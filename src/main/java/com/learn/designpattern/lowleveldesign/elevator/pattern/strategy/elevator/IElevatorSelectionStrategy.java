package com.learn.designpattern.lowleveldesign.elevator.pattern.strategy.elevator;

import com.learn.designpattern.lowleveldesign.elevator.entity.ElevatorThreadTask;
import com.learn.designpattern.lowleveldesign.elevator.entity.MovingDirection;

import java.util.List;

@FunctionalInterface
public interface IElevatorSelectionStrategy {
	ElevatorThreadTask selectElevatorTask(List<ElevatorThreadTask> elevatorThreadTaskList,
			int floorNumber, MovingDirection movingDirection);
}
