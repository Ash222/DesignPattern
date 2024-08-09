package com.learn.designpattern.lowleveldesign.tictactoe.strategy.gamewinning;

import com.learn.designpattern.lowleveldesign.tictactoe.api.IGameWinningStrategy;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Board;
import com.learn.designpattern.lowleveldesign.tictactoe.models.CellState;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Move;

public class RowColumnDiagonalWinningStrategy implements IGameWinningStrategy {
	
	@Override
	public boolean checkWinner(final Board board, final Move move) {
		
		int row = move.getCell().getRow();
		int column = move.getCell().getColumn();
		char playerSymbol = board.getMatrix().get(row).get(column)
				.getPlayer().getSymbol();
		
		// check in row
		if (checkRowAndColumnWinner(row, column, playerSymbol, board)) {
			return true;
		}
		
		// now we will check in the diagonals
		return checkDiagonal(row, column, playerSymbol, board);
	}
	
	private boolean checkDiagonal(final int row, final int column,
	                              final char playerSymbol, final Board board) {
		int dimension = board.getDimension();
		boolean isPrimaryDiagonalWinner = true;
		boolean isSecondaryDiagonalWinner = true;
		
		for (int i = 0; i < dimension; i++) {
			
			boolean isPrimaryDiagonalCellEmpty = board.getMatrix().get(i).get(i)
					.getCellState().equals(CellState.EMPTY);
			boolean isSecondaryDiagonalCellEmpty = board.getMatrix().get(i)
					.get(dimension - 1 - i).getCellState().equals(CellState.EMPTY);
			
			// Incase row/column cell is empty getPlayer is null
			if (isPrimaryDiagonalCellEmpty || board.getMatrix().get(i).get(i)
					.getPlayer().getSymbol() != playerSymbol) {
				isPrimaryDiagonalWinner = false;
			}
			
			if (isSecondaryDiagonalCellEmpty || board.getMatrix().get(i)
					.get(dimension - 1 - i).getPlayer().getSymbol() != playerSymbol) {
				isSecondaryDiagonalWinner = false;
			}
			
			if (!isPrimaryDiagonalWinner && !isSecondaryDiagonalWinner) {
				return false;
			}
			
		}
		
		return true;
	}
	
	private boolean checkRowAndColumnWinner(final int row, final int column,
	                                        final char playerSymbol, final Board board) {
		
		int dimension = board.getDimension();
		boolean isRowWinner = true;
		boolean isColumnWinner = true;
		
		for (int i = 0; i < dimension; i++) {
			
			boolean isRowCellEmpty = board.getMatrix().get(i).get(column)
					.getCellState().equals(CellState.EMPTY);
			boolean isColumnCellEmpty = board.getMatrix().get(row).get(i)
					.getCellState().equals(CellState.EMPTY);
			
			// Incase row/column cell is empty getPlayer is null
			if (isRowCellEmpty || board.getMatrix().get(i).get(column)
					.getPlayer().getSymbol() != playerSymbol) {
				isRowWinner = false;
			}
			
			if (isColumnCellEmpty || board.getMatrix().get(row).get(i)
					.getPlayer().getSymbol() != playerSymbol) {
				isColumnWinner = false;
			}
			
			if (!isColumnWinner && !isRowWinner) {
				return false;
			}
		}
		
		return true;
	}
}
