package com.learn.designpattern.lowleveldesign.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private final List<List<Cell>> matrix;
	private final int dimension;
	
	public Board(int dimension) {
		
		this.dimension = dimension;
		this.matrix = new ArrayList<>();
		
		for (int row = 0; row < dimension; row++) {
			
			this.matrix.add(new ArrayList<>());
			for (int col = 0; col < dimension; col++) {
				this.matrix.get(row).add(new Cell(row, col));
			}
		}
	}
	
	public List<List<Cell>> getMatrix() {
		return matrix;
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public void displayBoard() {
		
		for (int i = 0; i < matrix.size(); i++) {
			
			for (int j = 0; j < matrix.size(); j++) {
				if (matrix.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
					System.out.print("|   |");
				} else {
					System.out.print(
							"| " + matrix.get(i).get(j).getPlayer().getSymbol() + " |");
				}
			}
			
			System.out.println();
		}
	}
	
	public void applyMove(final Move move) {
		
		int row = move.getCell().getRow();
		int column = move.getCell().getColumn();
		
		this.getMatrix().get(row).get(column).setCellState(CellState.FILLED);
		this.getMatrix().get(row).get(column).setPlayer(move.getPlayer());
	}
}
