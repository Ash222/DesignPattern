package com.learn.designpattern.lowleveldesign.tictactoe.api;

import com.learn.designpattern.lowleveldesign.tictactoe.models.Board;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Move;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Player;

@FunctionalInterface
public interface IBotPlayingStrategy {
	Move move(Player player, Board board);
}
