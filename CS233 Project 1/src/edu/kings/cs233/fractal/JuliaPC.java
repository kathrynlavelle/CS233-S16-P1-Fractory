package edu.kings.cs233.fractal;

/**
 * This class calculates the number of steps before a pixel value is out of range. The calculation is specific to the
 * Julia Set Fractal.
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class JuliaPC implements PixelComputer {
	/** The maximum number of colors. */
	private int maxNumColors;
	/** The constant values for the Julia update. */
	private double constValue1, constValue2;
	/** The number of steps before a pixel "escapes". */
	private int result;
	
	/**
	 * The constructor method for a new JuliaPC.
	 * @param maxIterations The maximum number of iterations.
	 * @param constVal1 The first value that remains constant across all pixels.
	 * @param constVal2 The second value that remains constant across all pixels.
	 */
	public JuliaPC(int maxIterations, double constVal1, double constVal2) {
		maxNumColors = maxIterations;
		constValue1 = constVal1;
		constValue2 = constVal2;
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
		if ((Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) > 4) || iterations >= maxNumColors) {
			result = iterations;
		}
		else {
			double nextX = constValue1 + Math.pow(x, 2) - Math.pow(y, 2);
			double nextY = constValue2 + 2 * x * y;
			int nextIterations = iterations + 1;
			result = calculateSteps(nextX, nextY, x0, y0, nextIterations);
		}
		return result;
	}
}
