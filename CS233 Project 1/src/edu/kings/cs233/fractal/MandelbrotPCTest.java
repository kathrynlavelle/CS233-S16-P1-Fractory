package edu.kings.cs233.fractal;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MandelbrotPCTest {

	@Before
	public void setUp() throws Exception {
		
	} 

	@Test
	public void testCalculateSteps() throws InvalidValueException, InvalidGeneratorException {
		ImageGeneratorFactory igf = new MandelbrotGenerator();
		igf.createFactory(0);
		ImageFile image = new ImageFile(); 
		image.generatePixelData(igf, -2.14, 0.5, -1.2, 1.2);
	}

}
