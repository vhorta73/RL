package impl.world;

import interfaces.State;

import java.util.Set;

import constants.Action;
/**
 * @author Vasco
 * @param <T>
 *
 */
public class StateImpl<T> implements State {
    /**
     * The State value.
     */
	private final T stateValue;
	
	/**
	 * The Set of available actions
	 */
	private final Set<Action> availableAtions;
	
	/**
	 * Constructor.
	 * @param <T>
	 * 
	 * @param state the state value
	 * @param actions list of available actions
	 */
	public StateImpl(T state, Set<Action> actions) {
		this.stateValue      = (T) state;
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
		if ( this.availableAtions.equals(actions) && this.stateValue.equals(state.getState())) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> T getState() {
		return (T) stateValue;
	}
}
