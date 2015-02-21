package impl.world;

import interfaces.State;

import java.util.List;

import constants.Action;
/**
 * @author Vasco
 *
 */
public class StateImpl implements State {
    /**
     * The State value.
     */
	private final Object stateValue;
	
	/**
	 * The list of available actions
	 */
	private final List<Action> availableAtions;
	
	/**
	 * Constructor.
	 * 
	 * @param state the state value
	 * @param actions list of available actions
	 */
	public StateImpl(Object state, List<Action> actions) {
		this.stateValue      = state;
		this.availableAtions = actions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Action> getActionList() {
		return this.availableAtions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean equals(State state) {
		if ( state == null ) {
			return false;
		}
		
		List<Action> actions = state.getActionList();
		if ( this.availableAtions.equals(actions) && this.stateValue.equals(state.getState())) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getState() {
		return this.stateValue;
	}

}
