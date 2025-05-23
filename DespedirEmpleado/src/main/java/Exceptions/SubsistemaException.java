package Exceptions;

/**
 *
 * @author Jesús Ernesto López Ibara (252663)
 */
public class SubsistemaException extends Exception{
    
    public SubsistemaException (String message){
        super(message);
    }
    
    public SubsistemaException (String message, Throwable cause){
        super(message, cause);
    }
}
