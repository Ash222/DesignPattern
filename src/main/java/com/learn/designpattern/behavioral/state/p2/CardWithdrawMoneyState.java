package com.learn.designpattern.behavioral.state.p2;

public class CardWithdrawMoneyState implements IState {
	
	@Override
	public void insertCard() {
		
		System.out.println("One card is already there, no card can be further inserted" +
				". Invalid operation :: insertCard");
	}
	
	@Override
	public void ejectCard() {
		
		// card is ejected
		System.out.println("Card is being ejected.");
		
		// changing the state to NoCardState
		ChangeATMStateUtil.changeState(ATMState.INITIAL, ATM.getATM());
	}
	
	@Override
	public void enterPIN() {
		System.out.println("PIN is already entered. Invalid operation :: enterPIN.");
	}
	
	@Override
	public void withdrawMoney() {
		
		// withdraw money
		System.out.println("Money withdrawn successfully.");
		
		// change the state to exit state or NoCardState
		ChangeATMStateUtil.changeState(ATMState.INITIAL, ATM.getATM());
	}
}
