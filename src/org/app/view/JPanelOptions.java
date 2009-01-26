package org.app.view;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.app.model.FontSize;

@SuppressWarnings("serial")
public class JPanelOptions  extends JPanel{

	private JButton upSizeLetter;
	private JButton downSizeLetter;
	private JButton originalSizeLetter;

	public JPanelOptions() {
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout());
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		createJButtons();
		setJButtosListeners();
	}

	
	private void createJButtons(){		
		upSizeLetter = new JButton("A+");
		upSizeLetter.setName("upSizeLetter");
		
		this.add(upSizeLetter);

		downSizeLetter = new JButton("A-");
		downSizeLetter.setName("downSizeLetter");
		this.add(downSizeLetter);
		
		originalSizeLetter = new JButton("A");
		originalSizeLetter.setName("originalSizeLetter");
		this.add(originalSizeLetter);

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
}
