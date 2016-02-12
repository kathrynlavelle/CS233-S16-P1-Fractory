package edu.kings.cs233.fractal;

import edu.kings.cs233.fractal.PixelComputer;

/**
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class MultibrotPC implements PixelComputer {
	private int maxIterations;

	/**
	 * The constructor method for a new MandelbrotPC.
	 * @param maxIterations The maximum number of iterations.
	 */
	public MultibrotPC(int maxIterations) {
		/** The maximum number of colors. */
		maxIterations = this.maxIterations;
	}

	/**
	 * Calculates the number of steps before a pixel
	 * @param x The current value of x.
	 * @param y The new value of y.
	 * @param x0 The initial x value.
	 * @param y0 The initial y value.
	 * @param iterations The current iteration.
	 * @return The number of steps before a pixel "escapes".
	 */
	@Override
	public int calculateSteps(double x, double y, double x0, double y0, int iterations) {
		if ((Math.sqrt((x*x) + (y*y)) > 4) || iterations >= maxIterations) {
			return iterations;
		}
		else {
			double nextX = x0 + Math.pow(x, 3) - 3 * x * Math.pow(y, 2);
			double nextY = y0 + 3 * Math.pow(x, 2) * y - Math.pow(y, 3);
			int nextIterations = iterations + 1;
			return calculateSteps(nextX, nextY, x0, y0, nextIterations);
		}
	}
}
