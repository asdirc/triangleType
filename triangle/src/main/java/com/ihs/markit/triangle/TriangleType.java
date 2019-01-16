package com.ihs.markit.triangle;

public class TriangleType {
	public enum TriangleEnumType {
		INVALID, SCALENE, EQUILATERAL, ISOSCELES
	}

	private static boolean hasErrors;
	private static boolean isNumeric;

	public static TriangleEnumType getType(String[] args) {

		hasErrors = false;
		isNumeric = true;

		checkNumberOfInputSidesLengths(args);
		
		if (hasErrors) {
			return TriangleEnumType.INVALID;
		}

		checkSidesLengthAreNumeric(args);

		// int[] test = Arrays.stream(t).mapToInt(Integer::parseInt).toArray();
		double a = 0;
		double b = 0;
		double c = 0;
		if (!isNumeric) {
			return TriangleEnumType.INVALID;
		}
		a = Double.valueOf(args[0]).doubleValue();
		b = Double.valueOf(args[1]).doubleValue();
		c = Double.valueOf(args[2]).doubleValue();

		checkPositiveSidesLength(a, b, c);

		checkTriangleInequality(a, b, c);

		return displayTriangleType(a, b, c);

	}

	private static void checkNumberOfInputSidesLengths(String args[]) {
		if (args.length != 3) {
			System.out.println("A triangle must have exactly 3 side lengths");
			hasErrors = true;
		}
	}

	private static void checkSidesLengthAreNumeric(String[] args) {
		verifyIsNumeric(args[0]);
		verifyIsNumeric(args[1]);
		verifyIsNumeric(args[2]);
	}

	private static void checkPositiveSidesLength(double a, double b, double c) {
		checkPositiveSideLength(a);
		checkPositiveSideLength(b);
		checkPositiveSideLength(c);

	}

	private static void checkPositiveSideLength(double sideLength) {
		if (sideLength < 0) {
			System.out.println("The value " + sideLength + " is negative.");
			hasErrors = true;
		}
	}

	private static void checkTriangleInequality(double a, double b, double c) {
		if (a > b + c || b > a + c || c > a + b) {
			System.out
					.println("The lengths of the sides provided don't check the triangle inequality");
			hasErrors = true;
		}
	}

	private static void verifyIsNumeric(String numberToParse) {

		try {
			Double.valueOf(numberToParse);
		} catch (NumberFormatException e) {
			System.out.println("The value " + numberToParse
					+ " is not a valid number.");
			isNumeric = false;

		}
	}

	private static TriangleEnumType displayTriangleType(double a, double b,
			double c) {
		if (hasErrors) {
			System.out.println("Invalid \n");
			return TriangleEnumType.INVALID;
		} else if (a == b && b == c) {
			System.out.println("Equilateral \n");
			return TriangleEnumType.EQUILATERAL;
		} else if (a == b || b == c || a == c) {
			System.out.println("Isosceles \n");
			return TriangleEnumType.ISOSCELES;
		} else {
			System.out.println("Scalene \n");
			return TriangleEnumType.SCALENE;
		}

	}
	
	public static void main(String args[]) {
		TriangleType.getType(args);
	}

}
