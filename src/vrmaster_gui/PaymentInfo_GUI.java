package vrmaster_gui;

import vrmaster_user.*;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vrmaster_database.BookingInfo;
import vrmaster_database.Database;
import vrmaster_station.Command;
import vrmaster_station.PartyRoom;
import vrmaster_station.PartyRoomBookCommand;
import vrmaster_station.Station;
import vrmaster_station.StationBookCommand;
import vrmaster_user.PaymentInfo;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Checkbox;

public class PaymentInfo_GUI extends Window {

	/**
	 * Create the application.
	 */
	public PaymentInfo_GUI(Database db, int branchIndex, BookingInfo order) {
		//
		//
		initHeader("VR Master - Payment Info", new Dimension(200, 10), db);
		initialize(db, branchIndex, order);
		initFinal();	
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 * 
	 */
	private void initialize(Database db, int branchIndex, BookingInfo order) {
		JPanel bodyPanel = new JPanel();
		int employeeID = -1;
		frame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		
		JLabel enterEmail = new JLabel("Enter your email:");
		bodyPanel.add(enterEmail);
			
		JTextField emailField = new JTextField("example@domain.com");
		bodyPanel.add(emailField);
		// email
		
		JLabel enterCC = new JLabel("Enter your credit card number:");
		bodyPanel.add(enterCC);
		JTextField CCField = new JTextField("1234567890123456");
		bodyPanel.add(CCField);
		
		JLabel enterSecCode = new JLabel("Enter your security code:");
		bodyPanel.add(enterSecCode);
		JTextField SecField = new JTextField("111");
		bodyPanel.add(SecField);
		
		Employee employee = null;
		JLabel enterEmployeeNum = new JLabel("Enter your employee number (-1 if you are not an employee):");
		bodyPanel.add(enterEmployeeNum);
		JTextField empNum = new JTextField("00");
		bodyPanel.add(empNum);
		
		employeeID = Integer.parseInt(SecField.getText().substring(0, 2));
		
		if(employeeID != -1) {
			boolean found = false;
			for(int i = 0; i < db.allVRMasterEmployees.size() && !found; i++) {
				employee = db.allVRMasterEmployees.get(i);
				found = employee.getId() == employeeID;
			}
			if(!found) employeeID = -1;
		}
		
		bodyPanel.add(new JLabel("Subtotal:\t $" + order.getPrice()));
		if(employeeID != -1) {
			bodyPanel.add(new JLabel("Discount:\t-$" +  (order.getPrice() - employee.getDiscount().applyDiscount(order.getPrice()))));
			order.setPrice(employee.getDiscount().applyDiscount(order.getPrice()));
		}
		bodyPanel.add(new JLabel("Total:\t $" + order.getPrice()));
				
		JButton proceedButton = new JButton("Continue");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ccString = "";
				int secNum;
				
				if(CCField.getText().substring(0, 16).replaceAll("\\d", "") == "") ccString = CCField.getText().substring(0, 16);
				secNum = Integer.parseInt(SecField.getText().substring(0, 3));
				
				PaymentInfo payment = new PaymentInfo(ccString, secNum);
				Customer u = new Customer(payment, emailField.getText());
				
				if(u.pay()) {
					Command bookCommand;
					if(order.getRoom() instanceof Station) bookCommand = new StationBookCommand((Station)order.getRoom());
					else bookCommand = new PartyRoomBookCommand((PartyRoom)order.getRoom());
					bookCommand.execute();
				}
				
			}
		});
		bodyPanel.add(proceedButton);
	}
}
