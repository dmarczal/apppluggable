package org.test.app.model;

import org.app.model.CalcLogic;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalcLogic_Test {

	private CalcLogic calc;
	
	@BeforeClass
	public void setup(){
		calc = new CalcLogic();
	}
	
	@Test
	public void should_have_a_current_number(){
		calc.setCurrentNumber("10");
		Assert.assertTrue(calc.getCurrentNumber() == 10, "Should have a value");
	}
	
	@Test
	public void should_have_a_sum_current_number(){
		calc.setCurrentNumber("10");
		calc.sum("10");
		Assert.assertTrue(calc.getCurrentNumber() == 20, "Should have sum two values");
	}

	@Test
	public void should_have_a_subtract_current_number(){
		calc.setCurrentNumber("10");
		calc.subtract("10");
		Assert.assertTrue(calc.getCurrentNumber() == 0, "Should have subtract two values");
	}

	@Test
	public void should_have_a_divide_current_number(){
		calc.setCurrentNumber("10");
		calc.divide("10");
		Assert.assertTrue(calc.getCurrentNumber() == 1, "Should have divide two values");
	}

	@Test
	public void should_have_pow_current_number(){
		calc.setCurrentNumber("10");
		Assert.assertEquals(calc.pow("10"), 100.0, "Should have pow currentNumeber 2");
		Assert.assertEquals(calc.getCurrentNumber(), 100.0, "Should have pow currentNumeber 2");
	}

	@Test
	public void should_have_square_sqrt_of_current_number(){
		calc.setCurrentNumber("100");
		Assert.assertEquals(calc.sqrt("100"), 10.0, "Should have pow currentNumeber 2");
		Assert.assertEquals(calc.getCurrentNumber(), 10.0, "Should have pow currentNumeber 2");
	}
	
}
