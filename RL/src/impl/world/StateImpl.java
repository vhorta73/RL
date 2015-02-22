package impl.world;

import interfaces.State;

import java.util.Set;

import constants.Action;
/**
 * @author Vasco
 *
 */
public class StateImpl implements State {
    /**
     * The State value.
     */
	private final Integer stateValue;
	
	/**
	 * The Set of available actions
	 */
	private final Set<Action> availableAtions;
	
	/**
	 * Constructor.
	 * 
	 * @param state the state value
	 * @param actions list of available actions
	 */
	public StateImpl(Integer state, Set<Action> actions) {
		this.stateValue      = state;
		this.availableAtions = actions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Action> getActionList() {
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
		
		Set<Action> actions = state.getActionList();
		if ( this.availableAtions.equals(actions) && this.stateValue.equals(state.getStateValue())) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override	
	public Integer getStateValue() {
		return stateValue;
	}
}
