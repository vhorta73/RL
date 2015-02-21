package impl.world;

import interfaces.DataBank;
import interfaces.State;

import java.util.Set;

import constants.Action;

/**
 * Data Bank implementation.
 * 
 * @author Vasco
 *
 */
public class DataBankImpl implements DataBank {
	/**
	 * Values of all known state-actions.
	 */
	// Need to use Collections - investigate.
//	private Collection<State> stateActions;

	/**
	 * Constructor.
	 */
	public DataBankImpl() {
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(State previousState, Action actionTaken,
			State finalState, Boolean isGoal) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Action getBestAction(State currentState) {
		Action bestAction = null;
		
		// Get all available actions for this currentState
		Set<Action> stateActions = currentState.getActionList();

		// Get all known taken actions in the past for this state
		// that do exist in this stateActions set list.
		
		// Get the highest action to be returned
		
		return bestAction;
	}

}
