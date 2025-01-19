package com.learn.designpattern.lowleveldesign.elevator.service;

import com.learn.designpattern.lowleveldesign.elevator.entity.Building;
import com.learn.designpattern.lowleveldesign.elevator.entity.Elevator;
import com.learn.designpattern.lowleveldesign.elevator.entity.ElevatorButton;
import com.learn.designpattern.lowleveldesign.elevator.entity.ElevatorThreadTask;
import com.learn.designpattern.lowleveldesign.elevator.entity.Floor;
import com.learn.designpattern.lowleveldesign.elevator.entity.MovingDirection;
import com.learn.designpattern.lowleveldesign.elevator.exception.ElevatorNotAvailableException;
import com.learn.designpattern.lowleveldesign.elevator.exception.SameFloorException;
import com.learn.designpattern.lowleveldesign.elevator.pattern.strategy.elevator
		.IElevatorSelectionStrategy;
import com.learn.designpattern.lowleveldesign.elevator.pattern.strategy.elevator
		.MinimumDistanceElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorService {
	
	private final Building building;
	private final ExecutorService executorService;
	private final List<ElevatorThreadTask> elevatorThreadTaskList;
	private IElevatorSelectionStrategy elevatorSelectionStrategy;
	
	public ElevatorService() {
		this.building = new Building(1);
		this.elevatorThreadTaskList = new ArrayList<>();
		this.executorService = Executors.newFixedThreadPool(5);
		this.elevatorSelectionStrategy = new MinimumDistanceElevatorSelectionStrategy();
		init();
	}
	
	public IElevatorSelectionStrategy getElevatorSelectionStrategy() {
		return elevatorSelectionStrategy;
	}
	
	public void setElevatorSelectionStrategy(
			final IElevatorSelectionStrategy elevatorSelectionStrategy
	) {
		this.elevatorSelectionStrategy = elevatorSelectionStrategy;
	}
	
	public void init() {
		
		// initialize 5 elevators
		for (int i = 0; i < 5; i++) {
			final Elevator elevator = new Elevator(i + 1,
			                                       new ElevatorButton());
			final ElevatorThreadTask elevatorThreadTask = new ElevatorThreadTask(
					elevator);
			this.building.addElevators(elevator);
			elevatorThreadTaskList.add(elevatorThreadTask);
			executorService.submit(elevatorThreadTask);
		}
		
		// initialize 10 floors
		for (int i = 0; i < 30; i++) {
			this.building.addFloor(new Floor(i + 1));
		}
	}
	
	// press the floor button to wait for the nearest elevator to
	public void pressFloorButton(final int currentFloorNumber,
			final MovingDirection movingDirection) {
		// pressing the current floor button, simulation
		building.getFloorList().get(currentFloorNumber).getFloorButton()
		        .press(currentFloorNumber);
		final ElevatorThreadTask elevatorThreadTask = selectElevatorTask(
				currentFloorNumber, movingDirection);
		if (elevatorThreadTask == null) {
			throw new ElevatorNotAvailableException("All the elevators are currently " +
					                                        "busy. Please wait!");
		}
		elevatorThreadTask.addRequest(currentFloorNumber, movingDirection);
	}
	
	// when the elevator door opens again another pressElevatorButton action can be done.
	// it can be done anytime as long as there is someone inside the elevator.
	public void pressElevatorButton(final int fromFloorNumber, final int toFloorNumber,
			final int elevatorNumber) {
		if (fromFloorNumber == toFloorNumber) {
			throw new SameFloorException("Please press a different floor!");
		}
		
		final MovingDirection movingDirection = fromFloorNumber > toFloorNumber ?
				MovingDirection.DOWN : MovingDirection.UP;
		ElevatorThreadTask elevatorThreadTask = null;
		
		for (final ElevatorThreadTask elevatorTask : elevatorThreadTaskList) {
			if (elevatorTask.getElevator().getElevatorNumber() == elevatorNumber) {
				elevatorThreadTask = elevatorTask;
			}
		}
		
		if (elevatorThreadTask == null) {
			throw new ElevatorNotAvailableException("Elevator-" + elevatorNumber + " not "
					                                        + "available!");
		}
		
		System.out.print("Elevator-" + elevatorNumber + " :: ");
		elevatorThreadTask.getElevator().getElevatorButton().press(toFloorNumber);
		elevatorThreadTask.addRequest(toFloorNumber, movingDirection);
	}
	
	private ElevatorThreadTask selectElevatorTask(final int fromFloorNumber,
			final MovingDirection movingDirection) {
		return this.elevatorSelectionStrategy.selectElevatorTask(elevatorThreadTaskList,
		                                                         fromFloorNumber,
		                                                         movingDirection);
	}
	
	public void elevatorPositionDisplay() {
		for (final ElevatorThreadTask elevatorThreadTask : elevatorThreadTaskList) {
			final Elevator elevator = elevatorThreadTask.getElevator();
			final int elevatorNumber = elevator.getElevatorNumber();
			final int floorNumber = elevator.getDisplay().getFloorNumber();
			final MovingDirection elevatorDirection = elevator.getDisplay()
			                                                  .getMovingDirection();
			System.out.println("Elevator :: " + elevatorNumber + " :: is at floor :: " +
					                   floorNumber + " :: direction :: " +
					                   elevatorDirection);
		}
	}
	
	public void shutDownService() {
		// some other operation to make sure all the elevators moved to the nearest floors
		// so that the passenger can get-off safely.
		executorService.shutdown();
		System.out.println("Elevators are shutting down!");
	}
}
