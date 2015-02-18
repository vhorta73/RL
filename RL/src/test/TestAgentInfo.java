package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import impl.responses.AgentInfoImpl;
import interfaces.State;
import interfaces.responses.AgentInfo;

import org.junit.Before;
import org.junit.Test;

import constants.Action;

/**
 * Testing the AgentInfo
 * 
 * @author Vasco
 *
 */
public class TestAgentInfo {
    /**
     * The AgentInfo
     */
    private AgentInfo agentInfo;
    
    /**
     * Agent's Name
     */
    private String NAME = "Agent's Name";
    
    /**
     * Current State
     */
    private State currentState;
    
    /**
     * Previous State
     */
    private State previousState;
    
    /**
     * Previous Action
     */
    private Action PREVIOUS_ACTION = Action.IDLE;
    
    /**
     * Next Action
     */
    private Action NEXT_ACTION = Action.DOWN_RIGHT;
    
    /**
     * Amount of goals achieved
     */
    private Integer GOALS = 34;
    
    /**
     * Current State value
     */
    private double CURRENT_STATE_VALUE = 34.23;
    
    /**
     * Previous State value
     */
    private double PREVIOUS_STATE_VALUE = 321.54;
    
    @Before
    public void before() {
//        TODO: State Impl()
//        this.currentState = new StateImpl();
//        this.previousState = new StateImpl();
        this.agentInfo = new AgentInfoImpl();
        this.agentInfo.setName(NAME);
        this.agentInfo.setGoals(GOALS);
        this.agentInfo.setPreviousState(previousState);
        this.agentInfo.setPreviousStateValue(PREVIOUS_STATE_VALUE);
        this.agentInfo.setPreviousAction(PREVIOUS_ACTION);
        this.agentInfo.setNextAction(NEXT_ACTION);
        this.agentInfo.setCurrentState(currentState);
        this.agentInfo.setCurrentStateValue(CURRENT_STATE_VALUE);
    }
    
    @Test
    public void testPrint() {
        agentInfo.print();
    }
    
    @Test
    public void testName() {
        assertEquals(NAME, agentInfo.name());
    }

    @Test
    public void testGoals() {
        assertEquals(GOALS, agentInfo.goals());
    }

    @Test
    public void testPreviousState() {
        assertEquals(previousState, agentInfo.previousState());
    }

    @Test
    public void testCurrentState() {
        assertEquals(currentState, agentInfo.currentState());
    }

    @Test
    public void testPreviousStateValue() {
        assertTrue(PREVIOUS_STATE_VALUE == agentInfo.previousStateValue());
    }

    @Test
    public void testCurrentStateValue() {
        assertTrue(CURRENT_STATE_VALUE == agentInfo.currentStateValue());
    }

    @Test
    public void testPreviousAction() {
        assertEquals(PREVIOUS_ACTION, agentInfo.previousAction());
    }

    @Test
    public void testNextAction() {
        assertEquals(NEXT_ACTION, agentInfo.nextAction());
    }
}
