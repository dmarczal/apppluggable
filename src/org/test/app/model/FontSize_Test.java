package org.test.app.model;

import org.app.model.FontSize;
import org.testng.Assert;
import org.testng.annotations.*;

public class FontSize_Test {

	private FontSize f;
	private static final int BEGIN_SIZE = 12;
	
	
	@BeforeMethod
	public void before_all_test(){
		f = new FontSize();
	}

	@Test
	public void should_have_begin_value(){
		f.beginSize();
		Assert.assertEquals(f.getSize(), BEGIN_SIZE);
	}
	
	@Test
	public void should_have_increment_size(){
		f.incrementSize();
		Assert.assertEquals(f.getSize(), (BEGIN_SIZE+1));
		f.incrementSize();
		Assert.assertEquals(f.getSize(), (BEGIN_SIZE+2));
	}
	
	@Test
	public void should_have_decrement_size(){
		f.decrementSize();
		Assert.assertEquals(f.getSize(), (BEGIN_SIZE-1));
		f.decrementSize();
		Assert.assertEquals(f.getSize(), (BEGIN_SIZE-2));
	}
}
