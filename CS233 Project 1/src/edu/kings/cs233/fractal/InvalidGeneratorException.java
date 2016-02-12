package edu.kings.cs233.fractal;

/**
 * This class defines the checked exception that is thrown to indicate that a problem occurred while generating a fractal image.
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class InvalidGeneratorException extends Exception {

	/** Generated unique id. */
	private static final long serialVersionUID = 1722780634297695744L;
	
	/**
	 * Instantiates a new InvalidGeneratorException with no parameters.
	 */
	public InvalidGeneratorException() {}
	
	/**
	 * Instantiates a new InvalidValueException with a message.
	 * @param message The message.
	 */
	public InvalidGeneratorException(String message) {
		super(message);
	}

}
