package org.app.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelHello extends JPanel {
	private JLabel jlName;
	
	public JPanelHello(){
		setBorder(BorderFactory.createEtchedBorder());
		
		this.setName("JPanelHello");
		
		jlName = new JLabel("You are inside de Hello Panel");
		jlName.setName("jlName");
		this.add(jlName);
	}
}
