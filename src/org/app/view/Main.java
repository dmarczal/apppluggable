package org.app.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.app.ApplicationPlugin;
import org.app.model.FontSize;

@SuppressWarnings("serial")
public class Main extends JApplet implements Observer{

	private JMenuBar jmenu;
	private GridBagConstraints c;
	private JPanel jpMain;
	private JPanelOptions jpOptions;
	private JPanelSequencer jpSequencer;

	public void init() {
		inicializeVariables();
		addMenu();
		addMainPanel(jpMain);
		addPanelOptions();
		setLookAndFell();
	}

	private void setLookAndFell() {
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
			//			 UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setFontSizeLetter(12);
	}

	private void inicializeVariables(){
		setSize(700, 500);
		getContentPane().setLayout(new GridBagLayout());
		jmenu = new MenuBar(this);
		c = new GridBagConstraints();
		jpMain = new JPanelMain();
		jpOptions = new JPanelOptions(this);
		FontSize.getInstance().addObserver(this);
		jpSequencer = new JPanelSequencer(this);
	}


	public void addMenu(){
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		this.getContentPane().add(jmenu,c);
	}

	public void addMainPanel(JPanel newMain){
		this.getContentPane().remove(jpMain);
		jpMain = newMain;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;

		c.gridwidth = 1;


		if (newMain instanceof ApplicationPlugin) {
			LinkedHashMap<String, JPanel> ap = new LinkedHashMap<String, JPanel>();
			ap.put("Inicial", jpMain);
			if (((ApplicationPlugin) newMain).getPanelsList() != null){
				ap.putAll(((ApplicationPlugin) newMain).getPanelsList());
				jpSequencer.setList(ap);
				jpOptions.remove(jpSequencer);
				jpOptions.add(jpSequencer);
			}else{
				jpOptions.remove(jpSequencer);
			}
		}


		this.getContentPane().add(jpMain, c);
		changeFontSize(this, FontSize.getInstance().getSize());
		//SwingUtilities.updateComponentTreeUI(this);
	}

	public void addPanelOptions(){
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridwidth = 3;
		c.gridy = 3;
		this.getContentPane().add(jpOptions,c);	
	}

	private void setFontSizeLetter(int size){
		changeFontSize(this, size);
		SwingUtilities.updateComponentTreeUI(this);
	}

	private void changeFontSize(Container c, int size){
		Font f;

		for (Component	comp : c.getComponents()) {
			f = new Font(comp.getFont().getFamily(), comp.getFont().getStyle(), size);

			if (comp instanceof JMenu) {
				int count = ((JMenu) comp).getItemCount();
				for (int i = 0; i < count; i++) {
					((JMenu) comp).getItem(i).setFont(f);
				}
			}		
			comp.setFont(f);
			changeFontSize((Container)comp, size);
		}
	}


	@Override
	public void start() {
		super.start();
	}

	@Override
	public void stop() {
		super.stop();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setFontSizeLetter(FontSize.getInstance().getSize());
	}
}
