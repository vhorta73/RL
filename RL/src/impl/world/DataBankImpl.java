package impl.world;

import interfaces.DataBank;
import interfaces.State;

import java.util.HashMap;
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
	 * HashMap of all visited States to which an Action was made and led
	 * to another state to which a value is recorded.
	 */
	private HashMap<State,HashMap<Action,HashMap<State,Double>>> visitedStated;
	
	/**
	 * Constructor.
	 */
	public DataBankImpl() {
		this.visitedStated = new HashMap<State,HashMap<Action,HashMap<State,Double>>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(State previousState, Action actionTaken, State finalState, Boolean isGoal) {
		HashMap<Action,HashMap<State,Double>> actionState = this.visitedStated.get(previousState);
		HashMap<State,Double>                 stateValue;
		if ( actionState != null ) {
			stateValue = actionState.get(actionTaken);
			if ( stateValue != null ) {
				Double value = stateValue.get(finalState);
				value = value * 0.8;
				stateValue.put(finalState, value);
				actionState.put(actionTaken, stateValue);
				this.visitedStated.put(previousState, actionState);
			}
		}
		else {
			stateValue = new HashMap<State, Double>();
			stateValue.put(finalState,1.0);
			actionState = new HashMap<Action,HashMap<State,Double>>();
			actionState.put(actionTaken, stateValue);
			this.visitedStated.put(previousState, actionState);			
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Action getBestAction(State currentState) {
		HashMap<Action,HashMap<State,Double>> actionStates = this.visitedStated.get(currentState);

		// If we have not yet visited this State, any Action is good.
		// On this special case, return null.
		if ( actionStates == null ) {
			return null;
		}
		
		for ( Action a : actionStates.keySet() ) {
			Double value = getActionValue(actionStates.get(a));
			System.out.println("Got: "+value);
		}
		
		// Get all available actions for this currentState
		Set<Action> stateActions = currentState.getActionList();

		// Get all known taken actions in the past for this state
		// that do exist in this stateActions set list.
		for( Action a : stateActions ) {
			
			
		}
		
		// Get the highest action to be returned
		
		return Action.DOWN;
	}
	
	/**
	 * Get the Action value as the averaged sum of all State values divided by the number of States.
	 */
	Double getActionValue(HashMap<State,Double> stateValues) {
		int numberOfStates = 0;
		Double totalValue  = 0.0;
		for( State state : stateValues.keySet() ) {
			numberOfStates++;
			totalValue += stateValues.get(state);
		}

		// StateValue is the Set of all the states under one same Action
		return (totalValue/numberOfStates);
	}

}
