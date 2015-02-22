package impl.world;

import interfaces.Agent;
import interfaces.State;
import interfaces.World;

import java.util.HashSet;

import constants.Action;

/**
 * The World implementation.
 * 
 * @author Vasco
 *
 */
public class WorldImpl implements World {
	/**
	 * The world's map grid environment
	 */
	private State[][] ENVIRONMENT;
	
	/**
	 * Normal state
	 */
	private final Integer STATE_VALUE = 0;
	
	/**
	 * All Actions
	 */
	private final HashSet<Action> ALL_ACTIONS;
	
	/**
	 * Constructor.
	 */
	public WorldImpl(int y, int x, State goal, int yGoal, int xGoal) {
		// Initialize ALL_ACTIONS with all known actions
		ALL_ACTIONS = new HashSet<Action>();
		for( Action a : Action.values() ) {
			ALL_ACTIONS.add(a);
		}
		
		// Initialize the environment with unrestricted States.
		// Also set the goal at position xGoal, yGoal
		ENVIRONMENT = new State[y][x];
		for ( int yy = 0; yy < ENVIRONMENT.length; yy++) {
			for ( int xx = 0; xx < ENVIRONMENT[yy].length; xx++ ) {
				if ( yy == yGoal && xx == xGoal ) {
					ENVIRONMENT[yy][xx] = new StateImpl(goal.getStateValue(),goal.getActionList());
				}
				else {
				    ENVIRONMENT[yy][xx] = new StateImpl(STATE_VALUE, ALL_ACTIONS);
				}
			}
		}
	}
	
	@Override
	public void run() {
		showState(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showState(World world) {
		for( int x = 0; x < ENVIRONMENT[0].length; x++) {
			System.out.print("  "+x+" ");
		}
		System.out.println();
		for(int y = 0; y < ENVIRONMENT.length; y++ ) {
			for( int x = 0; x < ENVIRONMENT[y].length; x++ ) {
				System.out.print("  "+ENVIRONMENT[y][x].getStateValue()+" ");
			}
			System.out.println(" " + y);
		}
	}

	@Override
	public void showState(Agent agent) {
	}

}
