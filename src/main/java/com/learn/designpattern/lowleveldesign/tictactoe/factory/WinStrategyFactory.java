package com.learn.designpattern.lowleveldesign.tictactoe.factory;

import com.learn.designpattern.lowleveldesign.tictactoe.api.IGameWinningStrategy;
import com.learn.designpattern.lowleveldesign.tictactoe.strategy.gamewinning.RowColumnDiagonalWinningStrategy;

public class WinStrategyFactory {
	
	public static IGameWinningStrategy getFactory(final String strategy){
		
		if(strategy.equalsIgnoreCase("row")){
			return new RowColumnDiagonalWinningStrategy();
		}
		
		return null;
	}
}
