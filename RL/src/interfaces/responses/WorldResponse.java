package interfaces.responses;

import interfaces.State;

import java.util.List;

import constants.Action;

/**
 * World response object after an action was requested by the agent.
 * Returns the previous state the agent was in,
 * the action taken by the agent, the new state the agent ends up in
 * and a reward if any.
 * 
 * @author Vasco
 *
 */
public interface WorldResponse extends Response {
	/**
	 * The current state the agent is.
	 * 
	 * @return State
	 */
	State getCurrentState();
	
	/**
	 * The action taken at the previous state.
	 * 
	 * @return Action
	 */
	Action getAction();
	
	/**
	 * The actions available at the current state.
	 * 
	 * @return List<Action>
	 */
	List<Action> getAvailableActions();
	
	/**
	 * Checking if current state is goal state.
	 * 
	 * @return true if goal state.
	 */
	Boolean isGoal();
}
