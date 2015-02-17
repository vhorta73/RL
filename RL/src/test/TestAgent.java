package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import impl.world.AgentImpl;
import interfaces.Agent;
import interfaces.State;
import interfaces.responses.AgentInfo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import constants.Action;
/**
 * Testing the Agent package.
 * 
 * @author Vasco
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAgent {
    /**
     * The Agent
     */
	private Agent agent;

	/**
	 * Agent's name
	 */
	private String NAME = "Agent's Name";

	/**
	 * Previous Action
	 */
	private Action PREVIOUS_ACTION = Action.DOWN; 
	
	/**
	 * Next Action
	 */
	private Action NEXT_ACTION = Action.UP; 
	
	/**
	 * Dummy previous state object
	 */
	private String[] PREVIOUS_STATE_OBJECT = { "Previous State Object" };
	
	/**
	 * Dummy current state object
	 */
	private String[] CURRENT_STATE_OBJECT = { "Current State Object" };
	
	/**
	 * Goal amount
	 */
	private int GOAL = 2;
	
	/**
	 * States
	 */
	@Mock
	private State currentState, previousState;
	
    /**
     * Run before each test
     */
	@Before
	public void before() {
		// Mocking State
		currentState = Mockito.mock(State.class);
        Mockito.when(currentState.getState()).thenReturn(CURRENT_STATE_OBJECT);		
        Mockito.when(previousState.getState()).thenReturn(PREVIOUS_STATE_OBJECT);		

        // Initialize the agent to have expected values.
        
        // Setting NAME
        agent = new AgentImpl(NAME);
        
        // Set the previous and nextState as well as the goal to be 2
		List<Action> actionList = new ArrayList<Action>();
		actionList.add(PREVIOUS_ACTION);
		actionList.add(NEXT_ACTION);
		agent.worldResponse(previousState, actionList, true);
		agent.worldResponse(currentState,  actionList, true);
	}

	/**
	 * Agent was initialized with NAME.
	 * NAME is expected to be found on the returned AgentInfo class
	 * when calling for agent.info()
	 */
	@Test
    public void testName() {
		AgentInfo found = agent.info();
		assertEquals(NAME,found.name());
    }

	/**
	 * Agent was initialized with two goals.
	 * worldResponse() is expected to trigger to increments to the 
	 * internal goals value for this agent.
	 * GOAL value is expected to be found on the returned AgentInfo class
	 * when calling for agent.info()
	 */
	@Test
    public void testGoal() {
		AgentInfo found = agent.info();
		int goals       = found.goals();
		assertEquals(GOAL, goals);
    }

	/**
	 * Agent was initialized with current state.
	 * worldResponse() is expected to trigger an internal state shift.
	 */
	@Test
    public void testCurrentState() {
		AgentInfo found  = agent.info();
		State foundState = found.currentState();
		Object state     = foundState.getState();
		assertEquals(CURRENT_STATE_OBJECT, state);
    }

	/**
	 * Agent was initialized with previous state.
	 * worldResponse() is expected to trigger an internal state shift.
	 */
	@Test
    public void testPreviousState() {
		AgentInfo found = agent.info();
		State foundState = found.previousState();
		Object state = foundState.getState();
		assertEquals(PREVIOUS_STATE_OBJECT, state);
    }

	/**
	 * Next action is calculated based on external factors to the Agent class.
	 * When initializing Agent class, the nextAction is expected to be null
	 * since no trigger has yet happened to generate the calculation.
	 * However, there were two worldResponse() triggered and the getNextAction()
	 * is no longer expected to be null.
	 */
	@Test
    public void testGetNextAction() {
		Action action =	agent.getNextAction();
		assertNotNull(action);
    }

	/**
	 * The next action may not be ready with the agent has too much data to calculate it.
	 * At the initialization of the Agent class, it is not expected this to be the case.
	 * Thus this method is expected to be always ready.
	 */
	@Test
    public void testIsNextActionReady() {
		assertTrue(agent.isNextActionReady());
    }
}
