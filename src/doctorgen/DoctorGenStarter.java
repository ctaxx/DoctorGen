package doctorgen;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import doctorgen.flowpanels.FlowPanel;
import doctorgen.provider.FlowProvider;

public class DoctorGenStarter extends JFrame {

	DocumentData documentData = new DocumentData();
	
	Panel centralPanel;

	public DoctorGenStarter() {
		super("RTF generator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(470, 300);
		setLayout(new BorderLayout());
		
		Container pane = getContentPane();

		centralPanel = new Panel();
		final CardLayout cardLayout = new CardLayout();
		centralPanel.setLayout(cardLayout);

		FlowProvider flowProvider = new FlowProvider();

		for (FlowPanel panel : flowProvider.getStuff()) {
			centralPanel.add(panel, panel.panelName);
		}

		pane.add(centralPanel, BorderLayout.CENTER);
		
		Panel southPanel = new Panel();
		southPanel.setLayout(new FlowLayout());
		
		Button prevButton = new Button("prev");
		prevButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.previous(centralPanel);
			}
		});
		
		southPanel.add(prevButton);
		
		Button nextButton = new Button("next");
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(centralPanel);
			}
		});
		
		southPanel.add(nextButton);
		Button genButton = new Button("generate");
		genButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		southPanel.add(genButton);
		
		pane.add(southPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new DoctorGenStarter();
	}
}
