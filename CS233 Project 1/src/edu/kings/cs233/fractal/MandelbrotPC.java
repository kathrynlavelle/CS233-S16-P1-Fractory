package edu.kings.cs233.fractal;

import edu.kings.cs233.fractal.PixelComputer;

/**
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class MandelbrotPC implements PixelComputer {
	/** The maximum number of colors. */
	private int maxIterations;

	/**
	 * The constructor method for a new MandelbrotPC.
	 * @param maxIterations The maximum number of iterations.
	 */
	public MandelbrotPC(int maxIterations) {
		maxIterations = this.maxIterations;
	}

	/**
	 * Calculates the number of steps before a pixel "escapes".
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
			double nextX = x0 + Math.pow(x, 2) - Math.pow(y, 2);
			double nextY = y0 + 2 * x * y;
			int nextIterations = iterations + 1;
			return calculateSteps(nextX, nextY, x0, y0, nextIterations);
		}
	}
}
