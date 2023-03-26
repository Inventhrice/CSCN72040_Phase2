package vrmaster_gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import vrmaster_database.BookingInfo;
import vrmaster_database.Database;

import java.awt.Dimension;

public class PaymentInfo extends Window {

	/**
	 * Create the application.
	 */
	public PaymentInfo(Database db, BookingInfo order) {
		initHeader("VR Master - Payment Info", new Dimension(200, 10), db);
		initialize(order);
		initFinal();	
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(BookingInfo order) {
		JPanel bodyPanel = new JPanel();
		frame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		
		
	}

}
