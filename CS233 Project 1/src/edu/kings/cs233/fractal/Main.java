package edu.kings.cs233.fractal;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.kings.cs233.fractal.ImageFile;

/**
 * This class controls the generation of fractal images by displaying a menu and prompting the user for
 * the necessary arguments for a specific fractal set.
 * 
 * @author Kathryn Lavelle
 * @version 2016-02-11
 */
public class Main {
	/** Scanner for menu selection from keyboard. */
	private static Scanner menuScanner;
	/** Scanner for response to quit the program. */
	private static Scanner quitScanner;
	/** Scanner for fractal details. */
	private static Scanner detailScanner;
	/** The fractal bounds. */
	private static double xStart, yStart, xEnd, yEnd;
	/** The number of colors to used in the fractal image. */
	private static int numColors;
	
	/**
	 * Displays program menu and handles menu selections appropriately.
	 * @param args An array of String arguments from the command line (unused).
	 */
	public static void main(String[] args) {
		boolean quitProgram = false;
		
		System.out.println("Welcome to Fractory - The factory for generating fractal images!");
		System.out.println("Let's begin...");
		displayMenu();
		
		while (quitProgram == false) {
			try {
				switch (getMenuResponse()) {
				case 1:
					getFractalDetails();
					ImageFile mandelbrotImage = new ImageFile(512, 512, numColors);
					mandelbrotImage.generatePixelData(new MandelbrotGenerator(), xStart, xEnd, yStart, yEnd);
					if (mandelbrotImage.saveImage("mandelbrot")) {
						System.out.println("Image saved!");
					}
					break;
				case 2:
					getFractalDetails();
					ImageFile multibrotImage = new ImageFile(800, 800, numColors);
					multibrotImage.generatePixelData(new MultibrotGenerator(), xStart, xEnd, yStart, yEnd);
					if (multibrotImage.saveImage("multibrot")) {
						System.out.println("Image saved!");
					}
					break;
				case 3:
					getFractalDetails();
					ImageFile juliaImage = new ImageFile(512, 512, numColors);
					juliaImage.generatePixelData(new JuliaGenerator(), xStart, xEnd, yStart, yEnd);
					if (juliaImage.saveImage("julia")) {
						System.out.println("Image saved!");
					}
					break;
				case 4:
					if (getQuitResponse().equalsIgnoreCase("Y")) {
						System.out.println("Goodbye!");
						quitProgram = true;
					}
					else {
						quitProgram = false;
					}
					break;
				default:
					System.out.println("Sorry, your input does not match any of the menu items. Try again.");
					break;
				}
			}
			catch (InputMismatchException ime) {
				System.out.println("Sorry, I could not understand your response type. Try again.");
			}
			catch (NoSuchElementException nsee) {
				System.out.println("Sorry, I can't find your response. Try again.");
			}
			catch (IllegalStateException ise) {
				System.out.println("Oops.. Something has gone wrong with the Fractory. Try again.");
			}
			catch (InvalidGeneratorException ige) {
				System.out.println("Please get a clue, I can only handle three fractals!.");
			}
			catch (InvalidValueException ive) {
				// Do nothing.
			}
		}
		menuScanner.close();
		quitScanner.close();
		detailScanner.close();
		System.exit(0);
	}
	
	/**
	 * Displays menu to console.
	 */
	private static void displayMenu() {
		System.out.println("\nMENU:");
		System.out.println("1) Generate Mandelbrot Set Image\n"
				+ "2) Generate Multibrot Set Image\n"
				+ "3) Generate Julia Set Image\n"
				+ "4) Quit");
	}
	
	/**
	 * Prompts user for the menu option they wish to execute, and gets their response.
	 * @return The user's response.
	 */
	private static int getMenuResponse() {
		System.out.print("\nPlease select a menu option: ");
		menuScanner = new Scanner(System.in);
		return menuScanner.nextInt();
	}
	
	/**
	 * Asks user if they wish to quit the program, and gets their response.
	 * @return The user's decision to quit.
	 */
	private static String getQuitResponse() {
		System.out.print("\nAre you sure you want to quit? (Y/N): ");
		quitScanner = new Scanner(System.in);
		return quitScanner.nextLine();
	}
	
	private static void getFractalDetails() {
		detailScanner = new Scanner(System.in);
		System.out.print("Start x: ");
		xStart = detailScanner.nextDouble();
		System.out.print("Start y: ");
		yStart = detailScanner.nextDouble();
		System.out.print("End x: ");
		xEnd = detailScanner.nextDouble();
		System.out.print("End y: ");
		yEnd = detailScanner.nextDouble();
		System.out.print("Number of colors (max = 255): ");
		numColors = detailScanner.nextInt();
		if (numColors > 255) {
			System.out.println("Invalid color amount. The maximum number of colors is 255. Please Try again.");
			System.out.print("Number of colors: ");
			numColors = detailScanner.nextInt();
		}
	}
}
