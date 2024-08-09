package com.learn.designpattern.lowleveldesign.tictactoe;

import com.learn.designpattern.lowleveldesign.tictactoe.controller.GameController;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Bot;
import com.learn.designpattern.lowleveldesign.tictactoe.models.BotDifficultyLevel;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Game;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
	
	public static void main(String[] args) {
		
		GameController gameController = new GameController();
		// the below input can be taken from the user as well
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player(1, "Ashwini Kumar", 'X'));
		playerList.add(new Bot(1, "Bot-1", 'O', BotDifficultyLevel.EASY));
		
		Game game = gameController.createGame(3, playerList, "row");
		gameController.startGame(game);
	}
}
