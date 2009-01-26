package org.app.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.app.ApplicationPlugin;
import org.app.pluggable.LoadPlugins;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	private JMenu menu;
	private JMenuItem menu_Panel_One;
	private JMenuItem menu_Panel_Two;
	private JMenuItem menuExit;

	private Main main;
	
	
	public MenuBar(Main main) {
		this.main = main;
		inicializeVariables();
		setListeners();
		loadPlugins();
	}

	public void inicializeVariables(){
	
		menu = new JMenu("Menu");
		menu_Panel_One = new JMenuItem("Item A");
		menu_Panel_Two = new JMenuItem("Item B");		
	
		menu.setName("MenuBar");
	   
		menu_Panel_One.setName("Item A");
		
		menu.add(menu_Panel_One);
		
		menu_Panel_Two.setName("Item B");
		
		menu.add(menu_Panel_Two);
		
	    menuExit = new JMenuItem("Sair");
		
		menuExit.setName("Exit");
		
		menu.add(menuExit);	
		this.add(menu);		
	}
	
	public void setListeners(){
		menu_Panel_One.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				main.addMainPanel(new JPanelHello());
				
			}
		});
		
		menu_Panel_Two.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				main.addMainPanel(new JPanelMain());
				
			}
		});
		
		menuExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				cmdMenusairClick();	
			}
		});
	}
	
	public void loadPlugins(){
		LoadPlugins load = new LoadPlugins();
	       
		JMenu newMenu = new JMenu("Novo");
		
		ArrayList<Object[]> panels = load.addDynamicPlugin();
		
		for (final Object[] o : panels) {
			final ApplicationPlugin p = (ApplicationPlugin) o[0];
			String name = (String) ((Hashtable) o[1]).get("name");
			JMenuItem menu = new JMenuItem(name);
			
			
			menu.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					main.addMainPanel(p);
				}				
			});
			
			newMenu.add(menu);
			
			this.add(newMenu);
			
		}
	}
	
	
	private void cmdMenusairClick() {
		System.exit(0);
	}
}