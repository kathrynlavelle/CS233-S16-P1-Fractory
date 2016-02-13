package edu.kings.cs233.fractal;

//import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Beginning of test cases for the MandelbrotPC class.
 * @author Kathryn Lavelle
 * @version 2016-02-13
 */
public class MandelbrotPCTest {

	/**
	 * Tests the number of steps returned by the calculateSteps() method.
	 * @throws InvalidValueException
	 * @throws InvalidGeneratorException
	 */
	@Test
	public void testCalculateSteps() throws InvalidValueException, InvalidGeneratorException {
		ImageGeneratorFactory igf = new MandelbrotGenerator();
		igf.createFactory(0);
		ImageFile image = new ImageFile(); 
		image.generatePixelData(igf, -2.14, 0.5, -1.2, 1.2);
	}
}
