package com.learn.designpattern.lowleveldesign.tictactoe.builder;

import com.learn.designpattern.lowleveldesign.tictactoe.api.IGameWinningStrategy;
import com.learn.designpattern.lowleveldesign.tictactoe.exceptions
		.InvalidGameDimensionException;
import com.learn.designpattern.lowleveldesign.tictactoe.exceptions
		.InvalidNumberOfPlayerException;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Game;
import com.learn.designpattern.lowleveldesign.tictactoe.models.Player;

import java.util.List;

public class GameBuilder {
	
	private int dimension;
	private List<Player> playerList;
	private IGameWinningStrategy gameWinningStrategy;
	
	private GameBuilder() {
	}
	
	public static GameBuilder builder() {
		return new GameBuilder();
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public List<Player> getPlayerList() {
		return playerList;
	}
	
	public GameBuilder setDimension(final int dimension) {
		this.dimension = dimension;
		return this;
	}
	
	public GameBuilder setPlayerList(final List<Player> playerList) {
		this.playerList = List.copyOf(playerList);
		return this;
	}
	
	public IGameWinningStrategy getGameWinningStrategy() {
		return gameWinningStrategy;
	}
	
	public GameBuilder setGameWinningStrategy(
			final IGameWinningStrategy gameWinningStrategy) {
		this.gameWinningStrategy = gameWinningStrategy;
		return this;
	}
	
	private void checkDimensionAndPlayer() throws InvalidNumberOfPlayerException,
			InvalidGameDimensionException {
		
		if (playerList.size() != dimension - 1) {
			throw new InvalidNumberOfPlayerException("Given size of board is " + dimension
					+ ", but the number of players is " + playerList.size());
		}
		
		if (dimension < 3) {
			throw new InvalidGameDimensionException("Given size of the board is "
					+ dimension + ", which is less than the minimum allowed" +
					" board size (3)");
		}
	}
	
	public Game build() {
		
		try {
			checkDimensionAndPlayer();
		} catch (InvalidGameDimensionException | InvalidNumberOfPlayerException e) {
			e.printStackTrace();
			return null;
		}
		
		return new Game(this);
	}
}
