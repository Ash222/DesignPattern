package com.learn.designpattern.behavioral.state.p2;

import java.io.Serial;
import java.io.Serializable;

public class ATM implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	private IState state;
	
	private ATM() {
		
		// this will set the initial state of the atm
		ChangeATMStateUtil.changeState(ATMState.INITIAL, this);
	}
	
	public void insertCard() {
		this.state.insertCard();
	}
	
	public void ejectCard() {
		this.state.ejectCard();
	}
	
	public void enterPIN() {
		this.state.enterPIN();
	}
	
	public void withdrawMoney() {
		this.state.withdrawMoney();
	}
	
	public void changeState(final IState state) {
		this.state = state;
	}
	
	private static final class ATMHolder {
		private static final ATM atm = new ATM();
	}
	
	public static ATM getATM() {
		return ATMHolder.atm;
	}
	
	@Serial
	protected Object readResolve(){
		return getATM();
	}
}
