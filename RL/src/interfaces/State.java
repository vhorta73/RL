package interfaces;

import java.util.List;

import constants.Action;

/**
 * The State: the set of actions available.</br>
 *
 * State includes a set of predefined available actions for the agent to choose from.
 * These actions will lead to other States but the reason why this happens, is dealt
 * with by World's environment class. 
 * 
 * @author Vasco
 *
 */
public interface State  {
	/**
	 * Get the list of all available valid actions.
	 * 
	 * @return List of Actions
	 */
	List<Action> getActionList();

	/**
     * Compares two States if equal.
	 * 
	 * @param state The state to compare to.
	 * @return True if equal.
	 */
    Boolean equals(State state);
    
    /**
     * Get the State Object initialized value.
     */
    Object getState();
}
