package com.learn.designpattern.lowleveldesign.tictactoe.models;

public class Move {
	
	private final Player player;
	private final Cell cell;
	
	public Move(Player player, Cell cell) {
		this.player = player;
		this.cell = cell;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Cell getCell() {
		return cell;
	}
}
