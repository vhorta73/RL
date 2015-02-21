package interfaces;

import constants.Action;

/**
 * DataBank contains all historical Data for all previous state actions taken.
 * Data is given in a three element form: previous state, action taken, end state.
 * 
 * @author Vasco
 *
 */
public interface DataBank {
	/**
	 * Store the three element form event state-action-state and tell if goal was reached.
	 */
	void store(State previousState, Action actionTaken, State finalState, Boolean isGoal);

	/**
	 * Calculate what is the best action to be had for the current State given past experience on this state.
	 * 
	 * @param currentState the current state
	 * @return the best known action to take
	 */
    Action getBestAction(State currentState);
}
