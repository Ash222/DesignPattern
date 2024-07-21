package com.learn.designpattern.behavioral.state.p1;

public class CardPINState implements IATMMachineState {

    @Override
    public void insertCard() {
        System.out.println("One card is already there, not further card can be inserted" +
                ". Invalid operation :: insertCard");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card is being ejected.");
    }

    @Override
    public void enterPIN() {
        System.out.println("PIN entered successfully.");
    }

    @Override
    public void withdrawMoney() {
        System.out.println("First enter the PIN, then withdraw the money. Invalid " +
                "operation :: withdrawMoney");
    }
}
