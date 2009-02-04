package org.app.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.app.ApplicationPlugin;
import org.app.pluggable.LoadPlugins;

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
		//menu_Panel_One.setFont(new Font("monspaced", Font.BOLD, 19));
		
		
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
	
	int i = 10;
	
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
		
		final LinkedHashMap<String, ApplicationPlugin> plugins = load.addDynamicPlugin();
		
		for (final Object key : plugins.keySet()) {
			JMenuItem menu = new JMenuItem(key.toString());
			
			menu.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					main.addMainPanel(plugins.get(key));
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
