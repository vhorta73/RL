package interfaces;

import interfaces.responses.AgentInfo;
import constants.Action;

/**
 * For each action the Agent calculates on current state to be had, 
 * the World will return a new state, a list of new possible actions that can happen at this new state, 
 * and a boolean check if current new state is the goal.
 *
 * @author Vasco
 *
 */
public interface Agent extends DataBank {
    /**
     * World response for an action taken by the agent will be assigned to the agent.response().</br>
     * The agent will then take this response() and make needed calculations.
     * 
     * @param currentState the new state and available actions.
     * @param isGoal true if at goal state.
     */
    void worldResponse(State currentState, boolean isGoal); 

    /**
     * The World will ask the agent for the next action.</br>
     * Next action may not yet be ready by the Agent to be supplied.
     * This is to only advise the World when the next action is ready to be picked up.
     * 
     * @return True if the action was calculated and is ready to be requested.
     */
    Boolean isNextActionReady();
    
    /**
     * The World will ask the agent for the next action.</br>
     * Next action will be calculated by the agent and returned back to World.</br>
     * If the next Action is not yet calculated, null is returned.
     * 
     * @return Action chosen at current state.
     */
    Action getNextAction();
    
    /**
     * If for some reason the action received by the World is not valid anymore,
     * the World reserve the right to refuse such action as invalid and to request 
     * another action to be supplied by the Agent, from a new set of available actions.</br>
     * The World passes in the current State the Agent is still on, and the new list
     * of available Actions to be picked from, as well as the invalid Action previously received.</br>
     * The Agent will re-calculate the new Action to be chosen and return it to the World, 
     * however the Agent is penalised by missing a go, giving the other possible Agents, an advantage.</br>
     * If the World's given information on what should be previous action taken or the current state
     * does not match the ones at the Agent, a warning should be thrown, but the agent should take
     * what the World says as the truth.
     * 
     * @param currentState the Agent is in with available actions.
     * @param receivedAction invalid received Action refused by the World
     */
    void invalidAction(State currentState, Action receivedAction);
    
    /**
     * The agent's attributes
     */
    AgentInfo info();

}
