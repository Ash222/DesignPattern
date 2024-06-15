package com.learn.designpattern.behavioral.state.p2;

public class CardPINState implements IState {
	
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
		
		// pin entered
		System.out.println("PIN entered successfully.");
		
		// after entering the pin change the state to CardWithdrawMoneyState
		ChangeATMStateUtil.changeState(ATMState.WITHDRAW, ATM.getATM());
	}
	
	@Override
	public void withdrawMoney() {
		System.out.println("First enter the PIN, then withdraw the money. Invalid " +
				"operation :: withdrawMoney");
	}
}
