package test;

import static org.junit.Assert.assertEquals;
import impl.world.DataBankImpl;
import impl.world.StateImpl;
import interfaces.DataBank;
import interfaces.State;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import constants.Action;

/**
 * Unit testing the DataBank class.
 * 
 * @author Vasco
 *
 */
public class TestDataBank {
	/**
	 * The DataBank
	 */
	private DataBank dataBank;
	
	/**
	 * Default current State
	 */
	private State currentState;
	
	/**
	 * Some previous State
	 */
	private State previousState;
	
	/**
	 * Default action taken
	 */
	private Action ACTION_TAKEN = Action.DOWN_LEFT;
	
	/**
	 * Previous State value
	 */
	private Integer PREVIOUS_STATE_VALUE = 0;
	
	/**
	 * Current State value
	 */
	private Integer CURRENT_STATE_VALUE = 0;
	
	/**
	 * Initialise all required classes with the expected values.
	 */
	@Before
	public void before() {
		initPreviousState();           // Set the previous state
		initCurrentState();            // Set the current state
		dataBank = new DataBankImpl(); // Get a new instance of DataBankImpl
	}

	/**
	 * Check Store is happening by looking at the best action.
	 */
	@Test
	public void testBestAction() {
		dataBank.store(previousState, ACTION_TAKEN, currentState, true);
		Action bestActionExpected = Action.DOWN;
		Action bestActionFound = dataBank.getBestAction(previousState);
		assertEquals(bestActionExpected, bestActionFound);
	}
	
	private void initCurrentState() {
		currentState = new StateImpl(CURRENT_STATE_VALUE, getDefaultSetActions());
	}
	
	private void initPreviousState() {
		previousState = new StateImpl(PREVIOUS_STATE_VALUE, getDefaultSetActions());
	}

	/**
	 * Set a list of default Actions to be returned.
	 * 
	 * @return Set of actions
	 */
	private Set<Action> getDefaultSetActions() {
		Set<Action> action = new HashSet<Action>();
		action.add(Action.DOWN);
		action.add(Action.IDLE);
		action.add(Action.LEFT);
		action.add(Action.RIGHT);
		action.add(Action.UP);
		return action;
	}
}
