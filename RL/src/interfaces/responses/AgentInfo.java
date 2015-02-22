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
     * Agent's current state
     */
    State currentState();
    
    /**
     * Agent's previous state
     */
    State previousState();
    
    /**
     * Agent's previous action taken
     */
    Action previousAction();
    
    /**
     * Agent's next action if ready
     */
    Action nextAction();
    
    /**
     * The amount of goals found so far.
     */
    Integer goals();
    
    /**
     * Current State value
     */
    Double currentStateValue();
    
    /**
     * Previous State value
     */
    Double previousStateValue();
    
    /**
     * The vision radius set at the Agent's initialization.
     */
    Integer getVisionRadius();
    
    /**
     * Friendly print for Agent's Info
     */
    void print();
}
