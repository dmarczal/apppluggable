package org.test.app.view;

import org.app.view.calculador.Calculator;
import org.fest.swing.fixture.FrameFixture;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calculator_Test {

	private FrameFixture window;

	@BeforeClass
	public void setup(){
		 window = new FrameFixture(new Calculator());
		 window.show();
	}
	
	public void requireDisplayShow(String s){
		window.panel("jpMain").textBox("jtfDisplay").requireText(s);
	}
	
	public void clickAt(String panel, String jbutton){
		window.panel(panel).button(jbutton).click();
	}
	
	@BeforeMethod
	public void clearDisplay(){
		window.panel("jpCenter").button("AC").click();
	}

/*	
	@Test
	public void should_Clear_Display(){
		window.panel("jpMain").textBox("jtfDisplay").setText("45");
		
		clickAt("jpCenter", "AC");
		requireDisplayShow("0");
	}
	
	/*======================================================== Numbers Input
	@Test
	public void should_Insert_number_0(){
		clickAt("jpCenter","0");
		requireDisplayShow("0");
	}
	
	@Test
	public void should_Insert_number_1(){
		clickAt("jpCenter","1");
		requireDisplayShow("1");
	}

	
	@Test
	public void should_Insert_number_2(){
		clickAt("jpCenter","2");
		requireDisplayShow("2");
	}

	@Test
	public void should_Insert_number_3(){
		clickAt("jpCenter","3");
		requireDisplayShow("3");
	}

	@Test
	public void should_Insert_number_4(){
		clickAt("jpCenter","4");
		requireDisplayShow("4");
	}

	@Test
	public void should_Insert_number_5(){
		clickAt("jpCenter","5");
		requireDisplayShow("5");
	}

	@Test
	public void should_Insert_number_6(){
		clickAt("jpCenter","6");
		requireDisplayShow("6");
	}

	@Test
	public void should_Insert_number_7(){
		clickAt("jpCenter","7");
		requireDisplayShow("7");
	}

	@Test
	public void should_Insert_number_8(){
		clickAt("jpCenter","8");
		requireDisplayShow("8");
	}
	
	@Test
	public void should_Insert_number_9(){
		clickAt("jpCenter","9");
		requireDisplayShow("9");
	}

	
	@Test
	public void should_Insert_number_123(){
		clickAt("jpCenter","1");
		clickAt("jpCenter","2");
		clickAt("jpCenter","3");
		
		requireDisplayShow("123");
	}

	@Test
	public void should_sum_number(){
		clickAt("jpCenter","3");
		clickAt("jpRight","+");
		clickAt("jpCenter","6");
		clickAt("jpRight","+");
		
		requireDisplayShow("9.0");
	}
	
	@Test
	public void should_subtract_number(){
		clickAt("jpCenter","3");
		clickAt("jpRight","-");
		clickAt("jpCenter","6");
		clickAt("jpRight","-");
		
		requireDisplayShow("-3.0");
	}
	
	
	@Test
	public void should_multiply_number(){
		clickAt("jpCenter","3");
		clickAt("jpRight","x");
		clickAt("jpCenter","6");
		clickAt("jpRight","x");
		
		requireDisplayShow("18.0");
	}
	
	@Test
	public void should_divide_number(){
		clickAt("jpCenter","6");
		clickAt("jpRight","/");
		clickAt("jpCenter","3");
		clickAt("jpRight","/");
		
		requireDisplayShow("2.0");
	}
	
	@Test
	public void should_calculate_number(){
		clickAt("jpCenter","6");
		clickAt("jpRight","/");
		clickAt("jpCenter","3");
		clickAt("jpRight","x");
		clickAt("jpCenter","2");
		clickAt("jpRight","+");
		clickAt("jpCenter","1");
		clickAt("jpRight","-");
		clickAt("jpCenter","3");		
		clickAt("jpBottom","=");
		
		requireDisplayShow("2.0");
	}

	@Test
	public void should_change_the_sinal_number(){
		clickAt("jpCenter","6");
		clickAt("jpCenter","±");
		
		requireDisplayShow("-6");
		
		clickAt("jpCenter","±");
		
		requireDisplayShow("6");
	}
	
	
	@Test
	public void should_pow_the__number(){
		clickAt("jpCenter","6");
		clickAt("jpRight","x²");
		
		requireDisplayShow("36");
	}
	
	@Test
	public void should_sqrt_the__number(){
		clickAt("jpCenter","9");
		clickAt("jpBottom","²√x");
		
		requireDisplayShow("3.0");
	}
*/
	@Test
	public void should_not_change_the_sinal_number(){
		clickAt("jpCenter","0");
		clickAt("jpCenter","±");
		
		requireDisplayShow("0");
	}
	
	@Test
	public void should_sum_the_number(){
		clickAt("jpCenter","9");
		clickAt("jpCenter",".");
		clickAt("jpRight","+");
		clickAt("jpCenter","1");
		clickAt("jpCenter",".");
		clickAt("jpBottom","=");
		
		requireDisplayShow("10.0");
	}
	
	/*====================================================================*/
	@AfterClass 
	public void tearDown() {
	   window.cleanUp();
	}

}
