package edu.kings.cs233.fractal;

import java.util.Scanner;

/**
 * Instantiates an object to generate a Julia Set fractal image.
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class JuliaGenerator implements ImageGeneratorFactory {

	/**
	 * Creates and returns an object to generate the image.
	 * @return A PixelComputer to generate a Julia Set fractal.
	 */
	@Override
	public PixelComputer createFactory(int maxIterations) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ConstValue1: ");
		double constValue1 = scanner.nextDouble();
		System.out.print("ConstValue2: ");
		double constValue2 = scanner.nextDouble();
				
		//scanner.close();
		return new JuliaPC(maxIterations, constValue1, constValue2);
	}
}
