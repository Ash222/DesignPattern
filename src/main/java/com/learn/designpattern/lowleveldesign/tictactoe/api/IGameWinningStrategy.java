package com.learn.designpattern.lowleveldesign.tictactoe.api;

import com.learn.designpattern.lowleveldesign.tictactoe.models.Board;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Move;

public interface IGameWinningStrategy {
	
	boolean checkWinner(Board board, Move move);
}