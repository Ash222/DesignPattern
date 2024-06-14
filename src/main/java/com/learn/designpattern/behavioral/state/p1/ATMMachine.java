package com.learn.designpattern.behavioral.state.p1;

public class ATMMachine implements IATMMachineState {

    private IATMMachineState atmMachineState;

    public ATMMachine() {

        // because initially there is no card in the atm
        this.atmMachineState = new NoCardState();
    }

    private void setAtmMachineState(final IATMMachineState atmMachineState) {
        this.atmMachineState = atmMachineState;
    }

    @Override
    public void insertCard() {

        // inserting the card
        this.atmMachineState.insertCard();

        // after inserting the card the state of the machine is changed to CardPINState
        if (this.atmMachineState instanceof NoCardState) {

            setAtmMachineState(new CardPINState());
        }
    }

    @Override
    public void ejectCard() {

        // ejecting the card
        this.atmMachineState.ejectCard();

        // after ejecting the card state of the atm changed to NoCardState
        if (this.atmMachineState instanceof NoCardState) {

            return;
        }

        setAtmMachineState(new NoCardState());
    }

    @Override
    public void enterPIN() {

        // enter the PIN of the card
        this.atmMachineState.enterPIN();

        // after entering the PIN the atm state is changed to CardWithdrawMoneyState
        if (this.atmMachineState instanceof CardPINState) {

            setAtmMachineState(new CardWithdrawMoneyState());
        }
    }

    @Override
    public void withdrawMoney() {

        // withdraw the money from atm
        this.atmMachineState.withdrawMoney();

        // after withdrawing the money atm state is changed to NoCardState
        if (this.atmMachineState instanceof CardWithdrawMoneyState) {

            setAtmMachineState(new NoCardState());
        }
    }
}
