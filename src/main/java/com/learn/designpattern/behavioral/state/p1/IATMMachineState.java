package com.learn.designpattern.behavioral.state.p1;

public interface IATMMachineState {

    void insertCard();
    void ejectCard();
    void enterPIN();
    void withdrawMoney();
}
