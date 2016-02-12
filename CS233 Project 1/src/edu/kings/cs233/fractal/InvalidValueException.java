package edu.kings.cs233.fractal;

/**
 * This class defines the unchecked exception that is thrown if PixelComputer.calculateSteps() returns a value that is less than
 * zero, or larger than the maximum number of colors known by the ImageFile instance.
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 *
 */
public class InvalidValueException extends RuntimeException {

	/** Generated unique id. */
	private static final long serialVersionUID = -3297572599244439404L;
	
	/**
	 * Instantiates a new InvalidValueException with no parameters.
	 */
	public InvalidValueException() {}
	
	/**
	 * Instantiates a new InvalidValueException with a message.
	 * @param message The message.
	 */
	public InvalidValueException(String message) {
		super(message);
	}
}
