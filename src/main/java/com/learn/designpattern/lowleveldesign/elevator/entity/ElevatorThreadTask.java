package com.learn.designpattern.lowleveldesign.elevator.entity;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class ElevatorThreadTask implements Runnable {
	
	private final Elevator elevator;
	// heaps because the adding, removing time complexity is O(logn)
	// peeking in O(1).
	private final PriorityQueue<Integer> movingUpElevatorQueue;
	private final PriorityQueue<Integer> movingDownElevatorQueue;
	private final Semaphore semaphore;
	
	public ElevatorThreadTask(final Elevator elevator) {
		this.elevator = elevator;
		// min-heap
		this.movingUpElevatorQueue = new PriorityQueue<>();
		// max-heap
		this.movingDownElevatorQueue = new PriorityQueue<>((a, b) -> b - a);
		this.semaphore = new Semaphore(1); // for thread safe-operation
	}
	
	public Elevator getElevator() {
		return elevator;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				processRequest();
			}
		} catch (Exception e) {
			System.out.println("Error while running elevator task!");
		}
	}
	
	// we can add request even when the elevator is moving
	public void addRequest(final int toFloor, final MovingDirection movingDirection) {
		try {
			semaphore.acquire();
			switch (movingDirection) {
				case UP -> movingUpElevatorQueue.offer(toFloor);
				case DOWN -> movingDownElevatorQueue.offer(toFloor);
			}
			
			// if the elevator is in stopped state then change it to moving
			if (elevator.getElevatorState() == ElevatorState.STOP) {
				elevator.setElevatorState(ElevatorState.MOVING);
			}
		} catch (InterruptedException e) {
			System.out.println("Error adding request");
		} finally {
			semaphore.release();
		}
	}
	
	private void processRequest() {
		
		try {
			
			while (!movingUpElevatorQueue.isEmpty() ||
					!movingDownElevatorQueue.isEmpty()) {
				
				Integer nextFloor = null;
				MovingDirection movingDirection = null;
				
				// allowing locking only while accessing the queues because while moving
				// passengers can press any floor button and for the elevators to go to.
				semaphore.acquire();
				if (!movingUpElevatorQueue.isEmpty()) {
					nextFloor = movingUpElevatorQueue.peek();
					movingDirection = MovingDirection.UP;
				} else if (!movingDownElevatorQueue.isEmpty()) {
					nextFloor = movingDownElevatorQueue.peek();
					movingDirection = MovingDirection.DOWN;
				}
				semaphore.release();
				
				if (nextFloor != null && movingDirection != null) {
					moveToFloor(nextFloor, movingDirection);
				}
			}
			
			// queues are empty, thus elevator is stopped
			elevator.setElevatorState(ElevatorState.STOP);
		} catch (Exception e) {
			System.out.println("Error in processRequest");
		}
	}
	
	private void moveToFloor(final int toFloor, final MovingDirection movingDirection) {
		
		try {
			
			// elevator current floor
			int currentFloor = elevator.getDisplay().getFloorNumber();
			// since the elevator has starting moving it state has changed to moving
			elevator.setElevatorState(ElevatorState.MOVING);
			
			// elevator is moving
			while (currentFloor != toFloor) {
				
				// setting the moving direction to up/down as the elevator starting
				// moving.
				elevator.getDisplay().setMovingDirection(movingDirection);
				Thread.sleep(1000); // simulate elevator movement
				currentFloor += (movingDirection == MovingDirection.UP) ? 1 : -1;
				elevator.getDisplay().setFloorNumber(currentFloor);
				System.out.println("Elevator at floor :: " + currentFloor);
				
				// checks for intermediate stops.
				// suppose while moving someone pressed an elevator button to go to a
				// particular floor this check is to handle that
				semaphore.acquire(); // so that no new items are added in queue
				if (movingDirection == MovingDirection.UP &&
						movingUpElevatorQueue.peek() == currentFloor) {
					movingUpElevatorQueue.poll();
					// elevator has reached the intermediate floor, so the doors will
					// open and close and moving direction will be idle temporarily.
					doorOpenCloseOperation();
					elevator.getDisplay().setMovingDirection(MovingDirection.IDLE);
				} else if (movingDirection == MovingDirection.DOWN &&
						movingDownElevatorQueue.peek() == currentFloor) {
					movingDownElevatorQueue.poll();
					// elevator has reached the intermediate floor, so the doors will
					// open and close and moving direction will be idle temporarily.
					doorOpenCloseOperation();
					elevator.getDisplay().setMovingDirection(MovingDirection.IDLE);
				}
				semaphore.release();
			}
			
			// will remove the current floor from the queue once we reach the targeted
			// floor
			semaphore.acquire();
			if (movingDirection == MovingDirection.UP) {
				movingUpElevatorQueue.poll();
			} else if (movingDirection == MovingDirection.DOWN) {
				movingDownElevatorQueue.poll();
			}
			semaphore.release();
			// elevator has reached the toFloor, so the doors will open and close
			doorOpenCloseOperation();
		} catch (InterruptedException e) {
			System.out.println("Error while moveToFloor");
		} finally {
			elevator.getDisplay().setMovingDirection(MovingDirection.IDLE);
		}
	}
	
	public void doorOpenCloseOperation() {
		// doors opening
		openDoor();
		try {
			Thread.sleep(1000); // simulate the delay
		} catch (Exception e) {
			System.out.println("Error in doorOpenCloseOperation!");
		}
		// doors closing
		closeDoor();
	}
	
	private void openDoor() {
		try {
			final int elevatorNumber = elevator.getElevatorNumber();
			System.out.println("Elevator-" + elevatorNumber + " door is opening");
			this.elevator.getElevatorDoor().setDoorState(DoorState.OPEN);
			Thread.sleep(1000); // little delay to simulate door opening
			System.out.println("Elevator-" + elevatorNumber + " door opened!");
		} catch (InterruptedException e) {
			System.out.println("Error in opening elevator door!");
		}
	}
	
	private void closeDoor() {
		try {
			final int elevatorNumber = elevator.getElevatorNumber();
			System.out.println("Elevator-" + elevatorNumber + " door is closing");
			this.elevator.getElevatorDoor().setDoorState(DoorState.CLOSED);
			Thread.sleep(1000); // little delay to simulate door closing
			System.out.println("Elevator-" + elevatorNumber + " door closed!");
		} catch (InterruptedException e) {
			System.out.println("Error in closing elevator door!");
		}
	}
}
