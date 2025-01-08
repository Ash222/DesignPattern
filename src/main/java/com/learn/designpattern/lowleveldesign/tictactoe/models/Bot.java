package com.learn.designpattern.lowleveldesign.tictactoe.models;

import com.learn.designpattern.lowleveldesign.tictactoe.api.IBotPlayingStrategy;
import com.learn.designpattern.lowleveldesign.tictactoe.factory.BotPlayingFactory;

public class Bot extends Player {
	
	private final IBotPlayingStrategy botPlayingStrategy;
	
	public Bot(final int id, final String name, final char symbol,
			final BotDifficultyLevel botDifficultyLevel) {
		super(id, name, symbol, PlayerType.BOT);
		this.botPlayingStrategy = BotPlayingFactory.getFactory(botDifficultyLevel);
	}
	
	@Override
	public Move makeMove(final Board board) {
		return botPlayingStrategy.move(this, board);
	}
}
