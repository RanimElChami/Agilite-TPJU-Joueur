package exceptions;

public class JoueurNullException extends Exception {
	// Parameterless Constructor
    public JoueurNullException() {}

    // Constructor that accepts a message
    public JoueurNullException(String message){
       super(message);
    }
}
