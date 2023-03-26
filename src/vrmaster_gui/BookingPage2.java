package vrmaster_gui;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vrmaster_database.Database;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class BookingPage2 extends Window{
	
	/**
	 * Create the application.
	 */
	public BookingPage2(Database db, int branchIndex) {
		initHeader("VR Master - Choose type of Room", new Dimension(50, 10), db);
		initialize(db, branchIndex);
		initFinal();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Database db, int branchIndex) {
		
		JPanel bodyPanel = new JPanel();
		frame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		
		JLabel chooseType = new JLabel("Choose the type of booking:");
		bodyPanel.add(chooseType);
		
		JButton btnIndividual = new JButton("Individual Booking");
		btnIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new BookingPage3(false, db, branchIndex);
			}
		});
		
		JButton btnGroup = new JButton("Group Booking");
		btnGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new BookingPage3(true, db, branchIndex);
			}
		});
		
		JButton btnArcade = new JButton("Arcade Booking");
		
		bodyPanel.add(btnIndividual);
		bodyPanel.add(btnGroup);
		bodyPanel.add(btnArcade);
	}

}
