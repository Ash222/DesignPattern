package com.learn.designpattern.behavioral.chain_of_responsibility.p1;

public class Main {
	
	public static void main(String[] args) {
		
		final LoggerFacade logger = LoggerFacade.getInstance();
		logger.debug("Main :: main :: some log data");
		logger.info("Main :: main :: debugging data");
	}
}
