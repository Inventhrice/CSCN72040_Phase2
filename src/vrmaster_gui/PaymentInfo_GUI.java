package vrmaster_gui;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import vrmaster_database.BookingInfo;
import vrmaster_database.Database;
import vrmaster_user.Customer;
import vrmaster_user.PaymentInfo;
import vrmaster_user.User;
import java.awt.Dimension;

public class PaymentInfo_GUI extends Window {

	/**
	 * Create the application.
	 */
	public PaymentInfo_GUI(Database db, int branchIndex, BookingInfo order) {
		initHeader("VR Master - Payment Info", new Dimension(200, 10), db);
		initialize(db, branchIndex, order);
		initFinal();	
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(Database db, int branchIndex, BookingInfo order) {
		JPanel bodyPanel = new JPanel();
		frame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		String email;
		PaymentInfo payment;
		
		// email
		// credit card number
		// security code
		
		//display the total
		Customer u = new Customer(payment, email);
		if(u.pay()) db.allBranches.get(branchIndex).addBooking(order);
	}

}
