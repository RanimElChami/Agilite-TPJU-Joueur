package exceptions;

public class ArgumentNotInstanceOfJoueur extends Exception {
	// Parameterless Constructor
    public ArgumentNotInstanceOfJoueur() {}

    // Constructor that accepts a message
    public ArgumentNotInstanceOfJoueur(String message){
       super(message);
    }
}
