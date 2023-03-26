package vrmaster_gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vrmaster_database.Database;

import java.awt.Dimension;

public class BookingPage3 extends Window {
	private	boolean isGroup;
	/**
	 * Create the application.
	 */
	public BookingPage3(boolean isGroup, Database db, int branchIndex) {
		initHeader("VR Master - Booking", new Dimension(200, 10), db);
		this.isGroup = isGroup;
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
		
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.X_AXIS));
		
		JLabel chooseDate = new JLabel("Choose date of booking:");
		bodyPanel.add(chooseDate);
		
		JLabel chooseTime = new JLabel("Choose time of booking:");
		bodyPanel.add(chooseTime);
		
		// if the date time is valid, display a list of room numbers
		
		if(isGroup);
		
		//select room number
		
		//continue to payment info
		
		//payment info
		// ask employee num, iterate list of employees, check if id is valid, apply discount if so
		
		Choice timeChoice = new Choice();
		for(int i = 9; i <= 16; i++) for(int j = 0; j < 2; j++) timeChoice.add(i + ":" + ((j % 2 == 0) ? "00" : "30")); 
		bodyPanel.add(timeChoice);
	}

}
