package org.app.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelMain extends JPanel{
	
	private JLabel jlName;
	
	public JPanelMain(){
		setBorder(BorderFactory.createEtchedBorder());
		
		this.setName("JPanelMain");
		
		jlName = new JLabel("You are inside de Main Panel");
		jlName.setName("jlName");
		this.add(jlName);
	}
}
