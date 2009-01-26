package org.app.view;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.app.model.FontSize;

@SuppressWarnings("serial")
public class JPanelOptions  extends JPanel{

	private JButton upSizeLetter;
	private JButton downSizeLetter;
	private JButton originalSizeLetter;

	private JComboBox jcbExercisetList;
	private Main main;
	
	public JPanelOptions(Main main) {
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout());
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		this.main = main;
				
		createJButtons();
		setJButtosListeners();
	}

	
	private void createJButtons(){		
		originalSizeLetter = new JButton("A");
		originalSizeLetter.setName("originalSizeLetter");
		this.add(originalSizeLetter);
		
		downSizeLetter = new JButton("A-");
		downSizeLetter.setName("downSizeLetter");
		this.add(downSizeLetter);
		
		upSizeLetter = new JButton("A+");
		upSizeLetter.setName("upSizeLetter");
		this.add(upSizeLetter);
	}

	
	private void setJButtosListeners() {
		upSizeLetter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FontSize.getInstance().incrementSize();
			}
		});

		downSizeLetter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FontSize.getInstance().decrementSize();
			}
		});
		
		originalSizeLetter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FontSize.getInstance().beginSize();
			}
		});
	}
	
	public void createComboBoxList(final LinkedHashMap<String, JPanel> l){
		jcbExercisetList = new JComboBox(l.keySet().toArray());
		
		
		jcbExercisetList.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String key = (String) cb.getSelectedItem();
				main.addMainPanel(l.get(key));
			}
		});
		
		this.add(jcbExercisetList);
		validate();
	}
	
}
