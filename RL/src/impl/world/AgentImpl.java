package impl.world;

import impl.responses.AgentInfoImpl;
import interfaces.Agent;
import interfaces.State;
import interfaces.responses.AgentInfo;

import java.lang.annotation.Inherited;
import java.util.List;

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
	private double currentStateValue;
	
	/**
	 * Previous State
	 */
	private State previousState;
	
	/**
	 * Previous State value
	 */
	private double previousStateValue;
	
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
	 * Agent's Constructor default name
	 */
	public AgentImpl() {
		this.name              = "Agent " + (int)(Math.random()*100);
		this.goals             = 0;
		this.nextActionIsReady = false;
	}

	/**
	 * Agent's Constructor with name
	 */
	public AgentImpl(String name) {
		this.name              = name;
		this.goals             = 0;
		this.nextActionIsReady = false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void worldResponse(State currentState, List<Action> availableActions, boolean isGoal) {
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
	public void invalidAction(State currentState, List<Action> availableActions, Action receivedAction) {
	}

	/**
	 * {@inheritDoc}
	 */
	public AgentInfo info() {
		AgentInfo agentInfo = new AgentInfoImpl();
	
		agentInfo.setCurrentState(currentState);
		agentInfo.setCurrentStateValue(currentStateValue);
		agentInfo.setGoals(goals);
		agentInfo.setName(name);
		agentInfo.setPreviousAction(previousAction);
		agentInfo.setNextAction(nextAction);
		agentInfo.setPreviousState(previousState);
		agentInfo.setPreviousStateValue(previousStateValue);

		return agentInfo;
	}

}
