package interfaces.responses;

import interfaces.State;
import constants.Action;

/**
 * Identifying information who this Agent is.
 * 
 * @author Vasco
 *
 */
public interface AgentInfo {
    /**
     * Agent's name.
     */
    String name();
    
    /**
     * Set Agent's name.
     */
    void setName(String name);
    
    /**
     * Agent's current state
     */
    State currentState();
    
    /**
     * Set Agent's current state
     */
    void setCurrentState(State currentState);
    
    /**
     * Agent's previous state
     */
    State previousState();
    
    /**
     * Set Agent's previous state
     */
    void setPreviousState(State previousState);
    
    /**
     * Agent's previous action taken
     */
    Action previousAction();
    
    /**
     * Set Agent's previous action taken
     */
    void setPreviousAction(Action previousAction);
    
    /**
     * Agent's next action if ready
     */
    Action nextAction();
    
    /**
     * Set Agent's next Action
     */
    void setNextAction(Action nextAction);
    
    /**
     * The amount of goals found so far.
     */
    Integer goals();
    
    /**
     * Set the amount of goals found so far.
     */
    void setGoals(Integer goals);
    
    /**
     * Current State value
     */
    double currentStateValue();

    /**
     * Set current State value
     */
    void setCurrentStateValue(double currentStateValue);

    /**
     * Previous State value
     */
    double previousStateValue();

    /**
     * Set previous State value
     */
    void setPreviousStateValue(double previousStateValue);

    /**
     * Friendly print for Agent's Info
     */
    void print();
}
