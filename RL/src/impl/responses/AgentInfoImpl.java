package impl.responses;

import interfaces.State;
import interfaces.responses.AgentInfo;
import constants.Action;

public class AgentInfoImpl implements AgentInfo {
    /**
     * Agent's name
     */
    private String name;

    /**
     * Agent's current State
     */
    private State currentState;
    
    /**
     * Agent's previous State
     */
    private State previousState;
    
    /**
     * Agent's previous action
     */
    private Action previousAction;
    
    /**
     * Agent's next action if ready
     */
    private Action nextAction;
    
    /**
     * Agent's goals
     */
    private Integer goals;
    
    /**
     * Agent's current State value
     */
    private double currentStateValue;
    
    /**
     * Previous state value
     */
    private double previousStateValue;
    

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
    public void setName(String name) {
        this.name = name;
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
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
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
    public void setPreviousState(State previousState) {
        this.previousState = previousState;
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
    public void setPreviousAction(Action previousAction) {
        this.previousAction = previousAction;
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
    public void setNextAction(Action nextAction) {
        this.nextAction = nextAction;
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
    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double currentStateValue() {
        return this.currentStateValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentStateValue(double currentStateValue) {
        this.currentStateValue = currentStateValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double previousStateValue() {
        return this.previousStateValue;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPreviousStateValue(double previousStateValue) {
        this.previousStateValue = previousStateValue;
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
