package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import impl.world.StateImpl;
import interfaces.State;

import java.util.HashSet;
import java.util.Set;

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
	private Set<Action> actions;
	
	@Before
	public void before() {
		actions = new HashSet<Action>();
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
		Set<Action> foundActions = state.getActionList();
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
		Set<Action> newActions = new HashSet<Action>();
		newActions.add(Action.DOWN);
		State expected = new StateImpl(STATE_VALUE, newActions);
		assertTrue(!state.equals(expected));
	}

	/**
	 * Test the State value.
	 */
	@Test
	public void testStateValue() {
		Integer stateValueFound = state.getStateValue();
		assertEquals(STATE_VALUE, stateValueFound);
	}
}