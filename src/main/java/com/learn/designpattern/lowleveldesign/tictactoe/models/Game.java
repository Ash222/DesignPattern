package com.learn.designpattern.lowleveldesign.tictactoe.models;

import com.learn.designpattern.lowleveldesign.tictactoe.api.IGameWinningStrategy;
import com.learn.designpattern.lowleveldesign.tictactoe.builder.GameBuilder;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private Board board;
	private List<Player> playerList;
	private List<Move> moveList;
	private GameState gameState;
	private int nextPlayerIndex;
	private Player winningPlayer;
	private IGameWinningStrategy gameWinningStrategy;
	
	private Game() {
	}
	
	public Game(GameBuilder gameBuilder) {
		
		this.playerList = new ArrayList<>(gameBuilder.getPlayerList());
		this.board = new Board(gameBuilder.getDimension());
		this.gameState = GameState.IN_PROGRESS;
		this.moveList = new ArrayList<>();
		this.nextPlayerIndex = 0;
		this.winningPlayer = null;
		gameWinningStrategy = gameBuilder.getGameWinningStrategy();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public List<Player> getPlayerList() {
		return playerList;
	}
	
	public List<Move> getMoveList() {
		return moveList;
	}
	
	public GameState getGameState() {
		return gameState;
	}
	
	public int getNextPlayerIndex() {
		return nextPlayerIndex;
	}
	
	public Player getWinningPlayer() {
		return winningPlayer;
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	public void setWinningPlayer(Player winningPlayer) {
		this.winningPlayer = winningPlayer;
	}
	
	/* Steps :
	 * 1. Remove the last played move from the list
	 * 2. Emptying the last played move from the cell
	 * 3. Decrementing the nextPlayerIndex
	 * */
	public void undoMove() {
		// getting the row and column for the matrix to make it empty
		int lastIndex = this.moveList.size() - 1;
		Move move = this.moveList.get(lastIndex);
		int row = move.getCell().getRow();
		int column = move.getCell().getColumn();
		// emptying the cell
		this.board.getMatrix().get(row).get(column).setCellState(CellState.EMPTY);
		this.board.getMatrix().get(row).get(column).setPlayer(null);
		// removing the last played move
		this.moveList.remove(lastIndex);
		// decrementing the nextPlayerIndex
		this.nextPlayerIndex--;
		// if the nextPlayerIndex in negative then the nextPlayerIndex should point
		// to the last player in the playerList
		if (this.nextPlayerIndex < 0) {
			this.nextPlayerIndex = this.playerList.size() - 1;
		}
	}
	
	/* Steps :
	 *  1. Player plays the move.
	 *  2. The valid move is applied to the board.
	 *  3. Add that move to the stack for undo operation.
	 *  4. Check for the winner.
	 *  5. Check the status of the board if all the cells are "FILLED",
	 *     then the game is "DRAW".
	 * */
	public void executeNextMove() {
		
		final Player player = this.playerList.get(this.nextPlayerIndex);
		Move move = null;
		
		// will only take the valid move from the player
		while (move == null) {
			// player will play the move
			move = player.makeMove(this.getBoard());
		}
		
		// player making the move on the board
		this.getBoard().applyMove(move);
		// adding that move to list for undo operation
		this.getMoveList().add(move);
		
		// check the winner
		if (this.gameWinningStrategy.checkWinner(this.getBoard(), move)) {
			this.setGameState(GameState.ENDED);
			this.setWinningPlayer(player);
		}
		
		// check the status of the board
		if (checkTheBoard()) {
			this.setGameState(GameState.DRAW);
		}
		
		this.nextPlayerIndex = this.nextPlayerIndex + 1;
		this.nextPlayerIndex = this.nextPlayerIndex % this.playerList.size();
	}
	
	// check the status of the board if the board is in "DRAW" state
	private boolean checkTheBoard() {
		
		int dimension = this.board.getDimension();
		
		for (int row = 0; row < dimension; row++) {
			
			for (int column = 0; column < dimension; column++) {
				if (this.board.getMatrix().get(row).get(column).getCellState()
						.equals(CellState.EMPTY)) {
					return false;
				}
			}
		}
		
		return true;
	}
}
