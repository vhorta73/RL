package interfaces.responses;

import interfaces.State;

import java.util.Set;

import constants.Action;

/**
 * World response object after an action was requested by the agent.
 * Returns the current state the agent is ending up in, the action
 * taken by the agent, and a reward if any.
 * 
 * @author Vasco
 *
 */
public interface WorldResponse extends Response {
    /**
     * The current state the agent is in now.
     * 
     * @return State
     */
    State currentState();
    
    /**
     * The previous action taken at the previous state.
     * 
     * @return Action
     */
    Action previousAction();
    
    /**
     * Set of Actions available at current state.
     * 
     * @return Set of available actions.
     */
    Set<Action> availableActions();
    
    /**
     * Check if current state is at the environment's defined goal state.
     * 
     * @return true if goal state.
     */
    Boolean isGoal();
}
