package com.ihs.markit.triangle;

import org.junit.Test;

import com.ihs.markit.triangle.TriangleType.TriangleEnumType;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TriangleTypeTest {

	@Test
	public void testWithNegativeNumber() {
		System.out.println("Test negative values => Invalid");

		assertTrue(TriangleEnumType.INVALID.equals(TriangleType.getType(new String[] { "-1", "-2", "-3" })));

	}
	
	@Test
	public void testWithScalene() {
		System.out.println("Test scalene");
		assertTrue(TriangleEnumType.SCALENE.equals(TriangleType.getType(new String[] { "1.2", "2", "3" })));
	}
	
	@Test
	public void testWithEquilateral() {
		System.out.println("Test equilateral");
		assertTrue(TriangleEnumType.EQUILATERAL.equals(TriangleType.getType(new String[] { "4", "4", "4" })));
	}
	
	@Test
	public void testWithIsosceles() {
		System.out.println("Test isosceles");
		assertTrue(TriangleEnumType.ISOSCELES.equals(TriangleType.getType(new String[] { "2", "2", "3" })));
	}
	
	@Test
	public void testWithINonNumeric() {
		System.out.println("Test non numeric values");
		assertTrue(TriangleEnumType.INVALID.equals(TriangleType.getType(new String[] { "a2", "2e", "?3" })));
	}
	
	@Test
	public void testInvalidTriangleInequality() {
		System.out.println("Test with invalid triangle inequality");
		assertTrue(TriangleEnumType.INVALID.equals(TriangleType.getType(new String[] { "2", "4", "33" })));
	}
}
