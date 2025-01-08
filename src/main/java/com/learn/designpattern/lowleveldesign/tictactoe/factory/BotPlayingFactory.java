package com.learn.designpattern.lowleveldesign.tictactoe.factory;

import com.learn.designpattern.lowleveldesign.tictactoe.api.IBotPlayingStrategy;
import com.learn.designpattern.lowleveldesign.tictactoe.models.BotDifficultyLevel;
import com.learn.designpattern.lowleveldesign.tictactoe.strategy.botplaying.EasyBotPlayingStrategy;

public class BotPlayingFactory {
	
	private BotPlayingFactory() {
	}
	
	public static IBotPlayingStrategy getFactory(
			final BotDifficultyLevel botDifficultyLevel) {
		
		if (botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
			return new EasyBotPlayingStrategy();
		}
		
		return null;
	}
}
