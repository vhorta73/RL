package interfaces;
/**
 * World is the running package, including all World properties and attributes.
 * 
 * Agents would live inside the World package and are given by the World, 
 * in turns, a chance to apply an action.
 * 
 * When an agent returns with a chosen action, the World responds with the next state
 * and with a flag to say if this new state is a goal or not.</br>
 * 
 * @author Vasco
 *
 */
public interface World extends Runnable {
    /**
     * Show the current World State.
     */
    void showState(World world);

    /**
     * Show current agent's State.
     */
    void showState(Agent agent);
    
}
