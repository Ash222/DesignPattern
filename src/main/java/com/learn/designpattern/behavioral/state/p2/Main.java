package com.learn.designpattern.behavioral.state.p2;

public class Main {
	
	public static void main(String[] args) {
		
		ATM atm = ATM.getATM();
		atm.ejectCard();
		atm.enterPIN();
		atm.withdrawMoney();
		atm.insertCard();
		atm.ejectCard();
		atm.withdrawMoney();
		atm.insertCard();
		atm.enterPIN();
		atm.ejectCard();
		atm.ejectCard();
		atm.insertCard();
		atm.enterPIN();
		atm.withdrawMoney();
		atm.withdrawMoney();
		atm.ejectCard();
	}
}
