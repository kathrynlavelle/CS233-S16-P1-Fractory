package edu.kings.cs233.fractal;

import edu.kings.cs233.fractal.ImageGeneratorFactory;
import edu.kings.cs233.fractal.PixelComputer;

/**
 * Instantiates an object to generate a Mandelbrot Set fractal image.
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class MandelbrotGenerator implements ImageGeneratorFactory {
	
	/**
	 * Creates and returns an object to generate the image.
	 * @return A PixelComputer to generate a Mandelbrot Set fractal.
	 */
	@Override
	public PixelComputer createFactory(int maxIterations) {
		return new MandelbrotPC(maxIterations);
	}
}
