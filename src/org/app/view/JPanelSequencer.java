package org.app.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelSequencer extends JPanel{

	private  LinkedHashMap<String, JPanel> l;
	private Main main;
	
	private JButton jbNext;
	private JButton jbPrevious;
	
	private JComboBox jcbList;
	
	public JPanelSequencer(Main main) {
		this.main = main;
		inicializeVariables();
		setListeners();
	}

	
	public void setList(LinkedHashMap<String, JPanel> l) {
		this.l = l;
		jcbList.removeAllItems();
		
		for (String s : l.keySet()) {
			jcbList.addItem(s);
		}
	}

	public void inicializeVariables(){
		
		Icon iconeForward = new ImageIcon("icones/backward_nav.gif");
		jbPrevious = new JButton(iconeForward);
		this.add(jbPrevious);
		
		Icon iconeBack = new ImageIcon("icones/forward_nav.gif");
		jbNext = new JButton(iconeBack);
		this.add(jbNext);
		
		
		jcbList = new JComboBox();
		this.add(jcbList);
	}
	
	private void setListeners(){

		jbNext.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = jcbList.getSelectedIndex();
				if (++x < l.size())
				  jcbList.setSelectedIndex(x);
			}
		});
		
		jbPrevious.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = jcbList.getSelectedIndex();
				if (x > 0 && x <= l.size())
				  jcbList.setSelectedIndex(--x);
			}
		});
		
		jcbList.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String key = (String) cb.getSelectedItem();
				if (key != null)
				   main.addMainPanel(l.get(key));
			}
		});
	}
}
