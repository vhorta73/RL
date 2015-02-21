package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import impl.world.StateImpl;
import interfaces.State;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import constants.Action;

public class TestState {
	/**
	 * The State
	 */
	private State state;
	
	/**
	 * The state value
	 */
	private Integer STATE_VALUE = 123;
	
	/**
	 * Available Actions
	 */
	private List<Action> actions;
	
	@Before
	public void before() {
		actions = new LinkedList<Action>();
		actions.add(Action.DOWN);
		actions.add(Action.UP);
		actions.add(Action.RIGHT);
		actions.add(Action.LEFT);
		actions.add(Action.DOWN_RIGHT);
		actions.add(Action.IDLE);
		state = new StateImpl(STATE_VALUE, actions);
	}
	
	/**
	 * Test if initially given actions are returned.
	 */
	@Test
	public void testGetActionList() {
		List<Action> foundActions = state.getActionList();
		assertEquals(actions, foundActions);
	}
	
	/**
	 * Test if two States of the same are equal.
	 */
	@Test
	public void testEqualStates() {
		State expected = new StateImpl(STATE_VALUE, actions);
		assertTrue(state.equals(expected));
	}

	/**
	 * Test if two States not equal.
	 */
	@Test
	public void testNotEqualStates() {
		List<Action> newActions = new LinkedList<Action>();
		newActions.add(Action.DOWN);
		State expected = new StateImpl(STATE_VALUE, newActions);
		assertTrue(!state.equals(expected));
	}

	/**
	 * Test the State value.
	 */
	@Test
	public void testStateValue() {
		Integer stateValueFound = (int)state.getState();
		assertEquals(STATE_VALUE, stateValueFound);
	}
}
