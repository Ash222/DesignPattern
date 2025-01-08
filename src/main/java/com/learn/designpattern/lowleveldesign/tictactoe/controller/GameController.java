package com.learn.designpattern.lowleveldesign.tictactoe.controller;

import com.learn.designpattern.lowleveldesign.tictactoe.api.IGameWinningStrategy;
import com.learn.designpattern.lowleveldesign.tictactoe.builder.GameBuilder;
import com.learn.designpattern.lowleveldesign.tictactoe.factory.WinStrategyFactory;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Bot;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Game;
import com.learn.designpattern.lowleveldesign.tictactoe.models.GameState;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Player;

import java.util.List;
import java.util.Scanner;

public class GameController {
	
	public Game createGame(final int dimension, final List<Player> playerList,
	                       final String strategy) {
		
		IGameWinningStrategy gameWinningStrategy = WinStrategyFactory
				.getFactory(strategy);
		
		return GameBuilder.builder()
				.setDimension(dimension).setPlayerList(playerList)
				.setGameWinningStrategy(gameWinningStrategy).build();
	}
	
	private void undo(final Game game) {
		game.undoMove();
	}
	
	private void executeNextMove(final Game game) {
		game.executeNextMove();
	}
	
	private Player getWinner(final Game game) {
		return game.getWinningPlayer();
	}
	
	private GameState getGameState(final Game game) {
		return game.getGameState();
	}
	
	private void displayBoard(final Game game) {
		game.getBoard().displayBoard();
	}
	
	public void startGame(final Game game) {
		
		// loop will keep on running till the game state is in "IN_PROGRESS"
		while (this.getGameState(game).equals(GameState.IN_PROGRESS)) {
			
			Scanner scanner = new Scanner(System.in);
			String userResponse = null;
			Player player = game.getPlayerList().get(game.getNextPlayerIndex());
			// display the board
			System.out.println("Current board ==> ");
			this.displayBoard(game);
			
			// undo option
			if (player != null && !(player instanceof Bot)) {
				System.out.println(player.getName() + ", do you want to undo? Y/N");
				userResponse = scanner.next();
			}
			
			if (userResponse != null && (userResponse.contains("Y") ||
					userResponse.contains("y"))) {
				this.undo(game);
			} else {
				this.executeNextMove(game);
			}
		}
		
		// display the board
		this.displayBoard(game);
		
		if (this.getGameState(game).equals(GameState.DRAW)) {
			System.out.println("Game is a draw. There is no winner!!");
			return;
		}
		
		System.out.println(this.getWinner(game).getName() + " has won the game." +
				" Congratulations !!");
	}
}
