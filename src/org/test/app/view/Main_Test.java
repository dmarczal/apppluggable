package org.test.app.view;

import java.awt.Font;

import javax.swing.JApplet;

import org.app.model.FontSize;
import org.app.view.Main;
import org.fest.swing.applet.AppletViewer;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.AppletLauncher;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main_Test {

	private AppletViewer viewer;
	private FrameFixture applet;
	private JApplet japplet;	
	
	@BeforeClass
	public void setup(){
		japplet = new Main();		  
		viewer = AppletLauncher.applet(japplet).start();
		applet = new FrameFixture(viewer);
		applet.show();
	}
	
	
	@Test
	public void should_have_a_menuItem_A(){
		applet.menuItem("Item A");
	}
	
	@Test
	public void should_have_a_menuItem_B(){
		applet.menuItem("Item B");
	}
	
	@Test
	public void should_have_Increase_Size(){
		applet.button("upSizeLetter").click();
		applet.font().equals(new Font("Arial",Font.PLAIN, FontSize.getInstance().getSize()));
		//applet.font().requireSize(FontSizeControl.getInstance().getSize());
	}
	
	@Test
	public void should_have_Decrease_Size(){
		applet.button("downSizeLetter").click();
		applet.font().equals(new Font("Arial",Font.PLAIN, FontSize.getInstance().getSize()));
		//applet.font().requireSize(FontSizeControl.getInstance().getSize());
	}
	
	@Test
	public void should_have_original_Size(){
		applet.button("originalSizeLetter").click();
		applet.font().equals(new Font("Arial",Font.PLAIN, FontSize.getInstance().getSize()));
	}
	
	@Test
	public void should_have_change_for_Hello_Panel(){
		applet.menuItem("Item A").click();
		applet.panel("JPanelHello").label("jlName").requireText("You are inside de Hello Panel");
	}
	
	@Test
	public void should_have_change_for_Main_Panel(){
		applet.menuItem("Item B").click();
		applet.panel("JPanelMain").label("jlName").requireText("You are inside de Main Panel");
	}
	
	@Test
	public void should_have_a_menuItem_Exit(){
		//applet.menuItem("Exit").click();
		//applet.close();
	}	

	
	@AfterClass
	protected void tearDown(){
	    viewer.unloadApplet();
	    applet.cleanUp();
	}
}
