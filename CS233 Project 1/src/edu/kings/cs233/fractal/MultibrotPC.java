package edu.kings.cs233.fractal;

/**
 * This class calculates the number of steps before a pixel value is out of range. The calculation is specific to the
 * Multibrot Set Fractal.
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class MultibrotPC implements PixelComputer {
	/** The maximum number of colors. */
	private int maxNumColors;
	/** The number of steps before a pixel "escapes". */
	private int result;

	/**
	 * The constructor method for a new MandelbrotPC.
	 * @param maxIterations The maximum number of iterations.
	 */
	public MultibrotPC(int maxIterations) {
		/** The maximum number of colors. */
		maxNumColors = maxIterations;
	}

	/**
	 * Calculates the number of steps before a pixel value is out of range.
	 * @param x The current value of x.
	 * @param y The new value of y.
	 * @param x0 The initial x value.
	 * @param y0 The initial y value.
	 * @param iterations The current iteration.
	 * @return The number of steps before a pixel "escapes".
	 */
	public int calculateSteps(double x, double y, double x0, double y0, int iterations) {
		if ((Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) > 4) || iterations >= maxNumColors) {
			result = iterations;
		}
		else {
			double nextX = x0 + Math.pow(x, 3) - 3 * x * Math.pow(y, 2);
			double nextY = y0 + 3 * Math.pow(x, 2) * y - Math.pow(y, 3);
			int nextIterations = iterations + 1;
			calculateSteps(nextX, nextY, x0, y0, nextIterations);
			result =  iterations;
		}
		return result;
	}
}
