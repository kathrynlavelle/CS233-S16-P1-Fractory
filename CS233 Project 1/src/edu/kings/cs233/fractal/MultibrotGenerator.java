package edu.kings.cs233.fractal;

/**
 * Instantiates an object to generate a Multibrot Set fractal image.
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class MultibrotGenerator implements ImageGeneratorFactory {

	/**
	 * Creates and returns an object to generate the image.
	 * @return A PixelComputer to generate a Multibrot Set fractal.
	 */
	@Override
	public PixelComputer createFactory(int maxIterations) {
		return new MultibrotPC(maxIterations);
	}
}
