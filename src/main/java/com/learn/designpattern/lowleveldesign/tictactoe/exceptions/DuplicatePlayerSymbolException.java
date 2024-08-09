package com.learn.designpattern.lowleveldesign.tictactoe.exceptions;

public class DuplicatePlayerSymbolException extends Exception{
	
	public DuplicatePlayerSymbolException(String message) {
		super(message);
	}
}
