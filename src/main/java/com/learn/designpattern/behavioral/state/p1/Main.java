package com.learn.designpattern.behavioral.state.p1;

public class Main {

    public static void main(String[] args) {

        ATMMachine machine = new ATMMachine();
        machine.enterPIN();
        machine.withdrawMoney();
        machine.insertCard();
        machine.enterPIN();
        machine.enterPIN();
        machine.withdrawMoney();
        machine.withdrawMoney();
    }
}
