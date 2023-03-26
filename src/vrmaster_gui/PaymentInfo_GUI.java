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
		int employee = -1;
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
		
		Checkbox checkbox = new Checkbox("Are you an employee?");
		checkbox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bodyPanel.add(checkbox);
		
		if(checkbox.getState()) {
			JLabel enterEmployeeNum = new JLabel("Enter your security code:");
			bodyPanel.add(enterEmployeeNum);
			JTextField empNum = new JTextField("000");
			bodyPanel.add(empNum);
			employee = Integer.parseInt(SecField.getText().substring(0, 3));
		}
		
		
		//total
		
		
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
