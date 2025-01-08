package com.learn.designpattern.lowleveldesign.tictactoe.strategy.botplaying;

import com.learn.designpattern.lowleveldesign.tictactoe.api.IBotPlayingStrategy;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Board;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Cell;
import com.learn.designpattern.lowleveldesign.tictactoe.models.CellState;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Move;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Player;

public class EasyBotPlayingStrategy implements IBotPlayingStrategy {
	
	// get the first empty cell and let the bot play there
	@Override
	public Move move(final Player player, final Board board) {
		
		int dimension = board.getDimension();
		
		for (int row = 0; row < dimension; row++) {
			for (int column = 0; column < dimension; column++) {
				if (board.getMatrix().get(row).get(column).getCellState()
						.equals(CellState.EMPTY)) {
					return new Move(player, new Cell(row, column));
				}
			}
		}
		
		return null;
	}
}
