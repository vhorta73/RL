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
	private String PREVIOUS_STATE_VALUE = "Previous State";
	
	/**
	 * Current State value
	 */
	private String CURRENT_STATE_VALUE = "CURRENT State";
	
	/**
	 * Initialise all required classes with the expected values.
	 */
	@Before
	public void before() {
		initPreviousState(); // Set the previous state
		initCurrentState();  // Set the current state
		dataBank = new DataBankImpl();
	}

	
	@Test
	public void test() {
		dataBank.store(previousState, ACTION_TAKEN, currentState, true);
		Action bestActionExpected = Action.DOWN;
		Action bestActionFound = dataBank.getBestAction(currentState);
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
