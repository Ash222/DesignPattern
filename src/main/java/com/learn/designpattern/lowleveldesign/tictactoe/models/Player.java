package com.learn.designpattern.lowleveldesign.tictactoe.models;

import com.learn.designpattern.lowleveldesign.tictactoe.exceptions.InvalidMoveException;

import java.util.Scanner;

public class Player {
	
	private final int id;
	private final String name;
	private final char symbol;
	private final PlayerType playerType;
	
	public Player(final int id, final String name, final char symbol) {
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.playerType = PlayerType.HUMAN;
	}
	
	public Player(final int id, final String name, final char symbol,
			final PlayerType playerType) {
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.playerType = playerType;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public PlayerType getPlayerType() {
		return playerType;
	}
	
	/* Player will play the valid move otherwise throw the error */
	public Move makeMove(final Board board) {
		
		final String playerName = this.name;
		Scanner scanner = new Scanner(System.in);
		System.out.println(playerName + ", please enter the row :: ");
		int row = scanner.nextInt();
		System.out.println(playerName + ", please enter the column :: ");
		int column = scanner.nextInt();
		int dimension = board.getDimension();
		
		try {
			
			if (row >= dimension || column >= dimension) {
				throw new InvalidMoveException("Dimension is :: " + dimension +
						                               ", but provided row is " + row +
						                               " and column is " + column);
			}
			
			if (board.getMatrix().get(row).get(column).getCellState().
			         equals(CellState.FILLED)) {
				throw new InvalidMoveException("Given move is invalid as the cell at ("
						                               + row + "," + column +
						                               ") isn't empty");
			}
		} catch (InvalidMoveException e) {
			e.printStackTrace();
			return null;
		}
		
		return new Move(this, new Cell(row, column));
	}
}
