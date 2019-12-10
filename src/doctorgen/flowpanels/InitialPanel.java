package doctorgen.flowpanels;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTable;

public class InitialPanel extends FlowPanel{
	TextField nameTextField, projectTextField, quantityTextField;
	JTable serials;
	
	public InitialPanel(){
		super();
		panelName = "initialPanel";
		
		Panel namePanel = new Panel();
		namePanel.setLayout(new FlowLayout());
		Label nameLabel = new Label("name");
		namePanel.add(nameLabel);
		nameTextField = new TextField(20);
		namePanel.add(nameTextField);
		add(namePanel);
		
		Panel quantityPanel = new Panel();
		quantityPanel.setLayout(new FlowLayout());
		Label quantityLabel = new Label("quantity");
		quantityPanel.add(quantityLabel);
		Choice quantityChoice = new Choice();
		quantityChoice.add("1");
		quantityChoice.add("2");
		quantityChoice.add("3");
		quantityChoice.add("4");
		quantityChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("choice was changed");
				
			}
		});
		quantityPanel.add(quantityChoice);
		add(quantityPanel);
		
	}
}
