package interfaces.responses;

/**
 * Immutable generic base response object.
 * 
 * @author Vasco
 *
 */
public interface Response {
    /**
     * Returns the object.
     * 
     * If an error exists, returns null
     */
    Object get();
    
    /**
     * Returns true if an error is found.
     */
    Boolean hasError();
    
    /**
     * Returns the Error if any
     */
    Object getError();
}
