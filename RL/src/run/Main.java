package run;

import impl.world.StateImpl;
import impl.world.WorldImpl;
import interfaces.State;
import interfaces.World;

import java.util.HashSet;

import constants.Action;

/**
 * The main class to run the application
 * 
 * @author Vasco
 *
 */
public class Main {

    /** 
     * Main.
     * @param args
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.launch();
    }
    
    private void launch() {
    	HashSet<Action> actions = new HashSet<Action>();
    	for( Action a : Action.values()) {
    		actions.add(a);
    	}
    	
    	State goal = new StateImpl(1, actions);
        World world = new WorldImpl(11,11, goal,5,5);
        world.run();
    }

}
