package com.learn.designpattern.behavioral.state.p2;

public class NoCardState implements IState {
	
	@Override
	public void insertCard() {
		
		// card insertion
		System.out.println("Card inserted successfully!");
		
		// change the state to CardPINState
		ChangeATMStateUtil.changeState(ATMState.PIN, ATM.getATM());
	}
	
	@Override
	public void ejectCard() {
		System.out.println("There is no card. Invalid operation :: ejectCard");
	}
	
	@Override
	public void enterPIN() {
		System.out.println("There is no card. Invalid operation :: enterPIN");
	}
	
	@Override
	public void withdrawMoney() {
		System.out.println("There is no card. Invalid operation :: withdrawMoney");
	}
}
