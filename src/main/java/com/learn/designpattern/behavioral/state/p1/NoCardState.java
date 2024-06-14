package com.learn.designpattern.behavioral.state.p1;

public class NoCardState implements IATMMachineState{

    @Override
    public void insertCard() {
        System.out.println("Card inserted !!");
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
