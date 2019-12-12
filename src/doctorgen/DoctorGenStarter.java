package doctorgen;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import doctorgen.flowpanels.FlowPanel;
import doctorgen.provider.FlowProvider;

public class DoctorGenStarter extends Frame {

	DocumentData documentData = new DocumentData();
	
	Panel centralPanel;

	public DoctorGenStarter() {
		super("RTF generator");

		setSize(500, 200);
		setLayout(new BorderLayout());

		centralPanel = new Panel();
		final CardLayout cardLayout = new CardLayout();
		centralPanel.setLayout(cardLayout);

		FlowProvider flowProvider = new FlowProvider();

		for (FlowPanel panel : flowProvider.getStuff()) {
			centralPanel.add(panel, panel.panelName);
		}

		add(centralPanel, BorderLayout.CENTER);
		
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
		
		add(southPanel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new DoctorGenStarter();

	}

}
