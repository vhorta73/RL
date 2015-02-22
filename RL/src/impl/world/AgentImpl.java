package impl.world;

import impl.responses.AgentInfoImpl;
import interfaces.Agent;
import interfaces.State;
import interfaces.responses.AgentInfo;

import java.lang.annotation.Inherited;

import constants.Action;

/**
 * {@link Inherited}
 * @author Vasco
 */
public class AgentImpl implements Agent {
    /**
     * Agent's name
     */
    private final String name;
    
    /**
     * Current State
     */
    private State currentState;
    
    /**
     * Current State value
     */
    private Double currentStateValue;
    
    /**
     * Previous State
     */
    private State previousState;
    
    /**
     * Previous State value
     */
    private Double previousStateValue;
    
    /**
     * Previous Action
     */
    private Action previousAction;
    
    /**
     * Next Action
     */
    private Action nextAction;
    
    /**
     * Ready to apply action flag
     */
    boolean nextActionIsReady;

    /**
     * Number of goals found
     */
    private int goals;

    /**
     * Agent's vision radius.
     */
    private final Integer VISION_RADIUS;
    
    /**
     * Agent's Constructor default name
     */
    public AgentImpl(Integer visionRadius) {
    	this.VISION_RADIUS     = visionRadius;
        this.name              = "Agent " + (int)(Math.random()*100);
        this.goals             = 0;
        this.nextActionIsReady = false;
    }

    /**
     * Agent's Constructor with name
     */
    public AgentImpl(String name, Integer visionRadius) {
    	this.VISION_RADIUS     = visionRadius;
        this.name              = name;
        this.goals             = 0;
        this.nextActionIsReady = false;
    }

    /**
     * {@inheritDoc}
     */
    public void worldResponse(State currentState, boolean isGoal) {
        if ( isGoal ) { this.goals++; }
        this.previousState = this.currentState;
        this.currentState = currentState;
    }

    /**
     * {@inheritDoc}
     */
    public Boolean isNextActionReady() {
        return nextActionIsReady;
    }

    /**
     * {@inheritDoc}
     */
    public Action getNextAction() {
        if ( nextActionIsReady ) {
            return nextAction;
        }
        else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void invalidAction(State currentState, Action receivedAction) {
    }

    /**
     * {@inheritDoc}
     */
    public AgentInfo info() {
        return new AgentInfoImpl(name, currentState, previousState, 
        		previousAction, nextAction, goals, currentStateValue, 
        		previousStateValue, VISION_RADIUS
        );
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public void store(State previousState, Action actionTaken,
			State finalState, Boolean isGoal) {
		// TODO Auto-generated method stub
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Action getBestAction(State currentState) {
		// TODO Auto-generated method stub
		return null;
	}
}
