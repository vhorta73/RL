package impl.responses;

import interfaces.State;
import interfaces.responses.AgentInfo;
import constants.Action;

public class AgentInfoImpl implements AgentInfo {
    /**
     * Agent's name
     */
    private final String name;

    /**
     * Agent's current State
     */
    private final State currentState;
    
    /**
     * Agent's previous State
     */
    private final State previousState;
    
    /**
     * Agent's previous action
     */
    private final Action previousAction;
    
    /**
     * Agent's next action if ready
     */
    private final Action nextAction;
    
    /**
     * Agent's goals
     */
    private final Integer goals;
    
    /**
     * Agent's current State value
     */
    private final Double currentStateValue;
    
    /**
     * Previous state value
     */
    private final Double previousStateValue;
    
    /**
     * Agent's vision radius
     */
    private final Integer visionRadius;
    

    public AgentInfoImpl(String name, State curreState, State previousState,
    		Action previousAction, Action nextAction, Integer goals, 
    		Double currentStateValue, Double previousStateValue, Integer visionRadius ) {
        this.name = name;
        this.currentState = curreState;
        this.previousState = previousState;
        this.previousAction = previousAction;
        this.nextAction = nextAction;
        this.goals = goals;
        this.currentStateValue = currentStateValue;
        this.previousStateValue = previousStateValue;
        this.visionRadius = visionRadius;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State currentState() {
        return this.currentState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State previousState() {
        return this.previousState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Action previousAction() {
        return this.previousAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Action nextAction() {
        return this.nextAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer goals() {
        return this.goals;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double currentStateValue() {
        return this.currentStateValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double previousStateValue() {
        return this.previousStateValue;
    }
    
    /**
     * {@inheritDoc}
     */
	@Override
	public Integer getVisionRadius() {
		return visionRadius;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public void print() {
        System.out.println("============================================");
        System.out.println(" AGENT: [" + name + "]");
        System.out.println("\t");
        System.out.println("    Goals: " + goals);
        System.out.println("    P.  State: [" + currentState + "] = " + currentStateValue);
        System.out.println("    P. Action: [" + previousAction + "]");
        System.out.println("    New State: [" + previousState + "] = " + previousStateValue);
        System.out.println("      ");
        System.out.println("============================================");
    }

}
