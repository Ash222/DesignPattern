package com.learn.designpattern.behavioral.state.p2;

import org.jetbrains.annotations.NotNull;

/*
 * This class is responsible to changing the state of the atm, rather than the state
 * concrete classes itself.
 * Pros :
 * 1. Separation of Concerns: The states are responsible only for their own behavior
 * and not for managing the ATM. This keeps the state classes simpler and focused
 * on their specific responsibilities.
 * 2. Easier to Test: Since state classes are not dependent on the ATM object,
 * they can be more easily tested in isolation.
 * 3. Less Coupling/No Circular Dependencies : This approach avoids tight coupling
 * between the state classes and the ATM class, which can make the system easier to
 * understand and maintain.
 * Potential issues :
 * 1. Complexity: If someone is reading or maintaining the code, they need to understand
 * that state transitions are managed by ChangeATMStateUtil. This can make the code
 * harder to follow.
 * 2. Debugging: When debugging, if there's an issue with state transitions, we need
 * to look through both the state classes and the ChangeATMStateUtil, increasing the
 * cognitive load.
 * 3. Inconsistent Transitions: If the logic inside ChangeATMStateUtil for handling
 * the INITIAL state transition is modified, it affects all the places where this
 * transition is invoked. This can lead to inconsistencies if not carefully managed.
 * 4. Maintenance Overhead: Any change in the state transition logic requires
 * modifications in multiple places, increasing the maintenance overhead. For instance,
 * if the state transition logic for ejectCard changes, we need to ensure that all
 * relevant parts of the code are updated, including calls to ChangeATMStateUtil.
 * */

public final class ChangeATMStateUtil {
	
	private ChangeATMStateUtil() {
	}
	
	public static void changeState(@NotNull final ATMState atmState,
	                               @NotNull final ATM atm) {
		
		final IState state = switch (atmState) {
			
			case PIN -> new CardPINState();
			case WITHDRAW -> new CardWithdrawMoneyState();
			default -> new NoCardState();
		};
		
		// changing the atm atmState
		atm.changeState(state);
	}
}
