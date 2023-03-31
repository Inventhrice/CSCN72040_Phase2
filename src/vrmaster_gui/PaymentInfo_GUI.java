package vrmaster_gui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vrmaster_database.BookingInfo;
import vrmaster_database.Database;
import vrmaster_fileio.FileIODatabase;
import vrmaster_station.*;
import vrmaster_user.Customer;
import vrmaster_user.Employee;
import vrmaster_user.PaymentInfo;

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
		
		JLabel enterEmployeeNum = new JLabel("Enter your employee number (-1 if you are not an employee):");
		bodyPanel.add(enterEmployeeNum);
		JTextField empNum = new JTextField("00");
		bodyPanel.add(empNum);
		
		Checkbox button = new Checkbox("Show Total");
		button.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(button.getState()) {
					int employeeID = -1;
					Employee employee = null;
					employeeID = Integer.parseInt(empNum.getText().substring(0, 2));
					
					if(employeeID != -1) {
						vrmaster_iterator.Iterator emplIterator = db.getEmployeeAggregate().iterator();
						boolean found = false;
						
						while(emplIterator.hasNext() && !found) {
							employee = ((Employee)(emplIterator.next()));
							found = employeeID == employee.getId();
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
								
								FileIODatabase fileIO = new FileIODatabase();
								try {
									fileIO.writeToFile(db);
								} catch (IOException e1) {
									e1.printStackTrace();
								}

								frame.setVisible(false);
								new Homepage(db);
							}
						}
					});
					bodyPanel.add(proceedButton);
				}
			}
		});		
		bodyPanel.add(button);
	}
}
